/*
 * Copyright 2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.gradle.plugin.pgp.signing

import org.gradle.api.Project
import org.gradle.util.ConfigureUtil

import org.gradle.plugin.pgp.signing.signatory.*

class SigningConfiguration {
	private Project project
	private Map<String, Signatory> signatories = [:]
	
	SigningConfiguration(Project project) {
		this.project = project
	}
	
	Map<String, Signatory> signatories(Closure block) {
		ConfigureUtil.configure(block, new SignatoriesConfigurer(this))
		signatories
	}
}