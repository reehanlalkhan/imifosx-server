/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.ideoholic.imifosx.organisation.teller.exception;

import org.ideoholic.imifosx.infrastructure.core.exception.AbstractPlatformResourceNotFoundException;

/**
 * Indicates that a cashier could not be found.
 *
 * @author Markus Geiss
 * @since 2.0.0
 */
public class CashierNotFoundException extends AbstractPlatformResourceNotFoundException {

    private static final String ERROR_MESSAGE_CODE = "error.msg.cashier.not.found";
    private static final String DEFAULT_ERROR_MESSAGE = "Cashier with identifier {0,number,long} not found!";

    /**
     * Creates a new instance.
     *
     * @param cashierId the primary key of the cashier
     */
    public CashierNotFoundException(Long cashierId) {
        super(ERROR_MESSAGE_CODE, DEFAULT_ERROR_MESSAGE, cashierId);
    }
}
