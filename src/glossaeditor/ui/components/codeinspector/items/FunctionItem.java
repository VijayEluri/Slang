/*
 *  Copyright 2010 cyberpython.
 * 
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *  under the License.
 */

package glossaeditor.ui.components.codeinspector.items;

/**
 *
 * @author cyberpython
 */
public class FunctionItem extends CodeInspectorItem{

    private String returnType;

    public FunctionItem(String name, String returnType){
        super(name);
        this.returnType = returnType;
    }

    public void setReturnType(String returnType){
        this.returnType = returnType;
    }

    public String getReturnType(){
        return this.returnType;
    }

}