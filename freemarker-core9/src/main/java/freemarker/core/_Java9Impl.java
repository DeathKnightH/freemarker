/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package freemarker.core;

import freemarker.ext.beans.BeansWrapper;

/**
 * Used internally only, might change without notice!
 * Used for accessing functionality that's only present in Java 9 or later.
 */
// Compile this against Java 9
@SuppressWarnings("Since15") // For IntelliJ inspection
public class _Java9Impl implements _Java9 {

    public static final _Java9 INSTANCE = new _Java9Impl();

    private static final Module ACCESSOR_MODULE = BeansWrapper.class.getModule();

    private _Java9Impl() {
        // Not meant to be instantiated
    }

    @Override
    public boolean isAccessibleAccordingToModuleExports(Class<?> accessedClass) {
        Module accessedModule = accessedClass.getModule();
        Package accessedPackage = accessedClass.getPackage();

        return accessedModule.isExported(accessedPackage.getName(), ACCESSOR_MODULE);
    }
}
