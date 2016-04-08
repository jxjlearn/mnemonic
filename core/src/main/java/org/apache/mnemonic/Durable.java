/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.mnemonic;

/**
 * this interface defines the interactive functionalities with Mnenomic core
 * part.
 *
 */

public interface Durable {

  /**
   * this function will be invoked after this non-volatile object is created
   * brandly new
   *
   */
  public void initializeAfterCreate();

  /**
   * this function will be invoked after this non-volatile object is restored
   * from its allocator
   *
   */
  public void initializeAfterRestore();

  /**
   * this function will be invoked by its factory to setup generic related info
   * to avoid expensive operations from reflection
   *
   * @param efproxies
   *          specify a array of factory to proxy the restoring of its generic
   *          field objects
   *
   * @param gftypes
   *          specify a array of types corresponding to efproxies
   */
  public void setupGenericInfo(EntityFactoryProxy[] efproxies, GenericField.GType[] gftypes);

  /**
   * this function could be called by user code to disable auto-reclaim for this
   * non-volatile object
   *
   */
  public void cancelAutoReclaim();

  /**
   * this function could be called by user code to register this object for
   * auto-reclaim
   *
   */
  public void registerAutoReclaim();

  /**
   * this function returns its bound handler for this object
   *
   * @return the handler of this object
   */
  public long getNonVolatileHandler();

  /**
   * return the setting for auto-reclaim
   *
   * @return the status of the auto-reclaim setting
   */
  public boolean autoReclaim();

  /**
   * manually destroy this object and release its memory resource
   *
   */
  public void destroy() throws RetrieveNonVolatileEntityError;

  /**
   * return the native field map info for native processing.
   *
   * @return the native field map info
   *
   */
  public long[][] getNativeFieldInfo();
}