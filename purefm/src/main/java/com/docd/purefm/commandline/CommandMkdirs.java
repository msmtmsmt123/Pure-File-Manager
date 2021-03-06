/*
 * Copyright 2014 Yaroslav Mytkalyk
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.docd.purefm.commandline;

/**
 * @author Doctoror
 *
 * mkdir - make directories
 * -p no error if existing, make parent directories as needed
 */
public final class CommandMkdirs extends BusyboxCommand {

    public CommandMkdirs(final String path) {
        super("mkdir -p " + CommandLineUtils.getCommandLineString(path));
    }
}
