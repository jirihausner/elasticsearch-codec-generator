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

import { IndexSettings } from '@indices/_types/IndexSettings'
import { RequestBase } from '@_types/Base'
import { ExpandWildcards, Indices } from '@_types/common'
import { Time } from '@_types/Time'

/**
 * @rest_spec_name indices.put_settings
 * @since 0.0.0
 *
 * @stability TODO
 */
export interface Request extends RequestBase {
  path_parts?: {
    index?: Indices
  }
  query_parameters?: {
    allow_no_indices?: boolean
    expand_wildcards?: ExpandWildcards
    flat_settings?: boolean
    ignore_unavailable?: boolean
    master_timeout?: Time
    preserve_existing?: boolean
    timeout?: Time
  }
  body: IndexSettingsBody
}

export class IndexSettingsBody extends IndexSettings {
  settings?: IndexSettings
}
