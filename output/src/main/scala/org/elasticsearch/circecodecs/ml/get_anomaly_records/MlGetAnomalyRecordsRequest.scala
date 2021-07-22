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

package org.elasticsearch.circecodecs.ml.get_anomaly_records

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs._ml._types.Page.{ Page }
import org.elasticsearch.circecodecs._types.Base.{ RequestBase }
import org.elasticsearch.circecodecs._types.common.{ Field, Id }
import org.elasticsearch.circecodecs._types.Numeric.{ double, integer }
import org.elasticsearch.circecodecs._types.Time.{ DateString }

@JsonCodec case class Request(
	path_parts: PathParts, 
	query_parameters: QueryParameters, 
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		job_id: Id
	)
	@JsonCodec case class QueryParameters(
		exclude_interim: Boolean, 
		from: integer, 
		size: integer, 
		start: DateString, 
		end: DateString
	)
	@JsonCodec case class Body(
		desc: Boolean, 
		exclude_interim: Boolean, 
		page: Page, 
		record_score: double, 
		sort: Field, 
		start: DateString, 
		end: DateString
	)
}

