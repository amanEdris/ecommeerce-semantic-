/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.uniquebook.utils;

import java.beans.Introspector;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang.WordUtils;

public class Utils {

    public static InputStream getResourceAsStream(String filename) {
        InputStream in = Utils.class.getClassLoader().getResourceAsStream(filename);
        return in;
    }

    public static FileOutputStream getResourceAsOutStream(String filename) {
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(Utils.class.getClassLoader().getResource(filename).getFile());
            return out;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return out;
    }

    public static String formatName(String h) {
        //remove inital space, lowercase letters, remove hypens
        h = WordUtils.capitalizeFully(h.trim().toLowerCase().replaceAll("[-]+", " "));
        //inital letter to lowercase
        h = Introspector.decapitalize(h);
        return h.replaceAll("[^A-Za-z]", "").toLowerCase();//remove all spaces
    }

}
