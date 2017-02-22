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
package org.ideoholic.imifosx.organisation.teller.handler;

import org.ideoholic.imifosx.commands.handler.NewCommandSourceHandler;
import org.ideoholic.imifosx.infrastructure.core.api.JsonCommand;
import org.ideoholic.imifosx.infrastructure.core.data.CommandProcessingResult;
import org.ideoholic.imifosx.organisation.teller.service.CashierWritePlatformService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Handles a modify cashier command.
 *
 * @author Markus Geiss
 * @see org.ideoholic.imifosx.organisation.teller.service.CashierWritePlatformService
 * @since 2.0.0
 */
public class ModifyCashierCommandHandler implements NewCommandSourceHandler {

    private final CashierWritePlatformService writePlatformService;

    /**
     * Creates a new instance.
     *
     * @param writePlatformService the {@code CashierWritePlatformService} used to access the backend
     */
    @Autowired
    public ModifyCashierCommandHandler(final CashierWritePlatformService writePlatformService) {
        super();
        this.writePlatformService = writePlatformService;
    }


    @Override
    public CommandProcessingResult processCommand(final JsonCommand command) {
        return this.writePlatformService.modifyCashier(command.entityId(), command);
    }
}