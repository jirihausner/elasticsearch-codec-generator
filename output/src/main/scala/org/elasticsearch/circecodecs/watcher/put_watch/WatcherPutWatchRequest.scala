/*
 * Licensed to Elasticsearch B.V. under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch B.V. licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.elasticsearch.circecodecs.watcher.put_watch

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs._spec_utils.Dictionary.{ Dictionary }
import org.elasticsearch.circecodecs._watcher._types.Action.{ Action }
import org.elasticsearch.circecodecs._watcher._types.Conditions.{ ConditionContainer }
import org.elasticsearch.circecodecs._watcher._types.Input.{ InputContainer }
import org.elasticsearch.circecodecs._watcher._types.Trigger.{ TriggerContainer }
import org.elasticsearch.circecodecs._types.Base.{ RequestBase }
import org.elasticsearch.circecodecs._types.common.{ Id, Metadata, VersionNumber }
import org.elasticsearch.circecodecs._types.Numeric.{ long }
import org.elasticsearch.circecodecs._types.Transform.{ TransformContainer }

@JsonCodec case class Request(
	path_parts: PathParts, 
	query_parameters: QueryParameters, 
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		id: Id
	)
	@JsonCodec case class QueryParameters(
		active: Boolean, 
		if_primary_term: long, 
		if_sequence_number: long, 
		version: VersionNumber
	)
	@JsonCodec case class Body(
		actions: Dictionary[String, Action], 
		condition: ConditionContainer, 
		input: InputContainer, 
		metadata: Metadata, 
		throttle_period: String, 
		transform: TransformContainer, 
		trigger: TriggerContainer
	)
}

