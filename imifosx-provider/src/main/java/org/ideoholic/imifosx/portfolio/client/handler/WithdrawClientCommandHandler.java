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
package org.ideoholic.imifosx.portfolio.client.handler;

import org.ideoholic.imifosx.commands.annotation.CommandType;
import org.ideoholic.imifosx.commands.handler.NewCommandSourceHandler;
import org.ideoholic.imifosx.infrastructure.core.api.JsonCommand;
import org.ideoholic.imifosx.infrastructure.core.data.CommandProcessingResult;
import org.ideoholic.imifosx.portfolio.client.service.ClientWritePlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@CommandType(entity = "CLIENT", action = "WITHDRAW")
public class WithdrawClientCommandHandler  implements NewCommandSourceHandler {
	
	private final ClientWritePlatformService clientWritePlatformService;

@Autowired
public WithdrawClientCommandHandler(final ClientWritePlatformService clientWritePlatformService) {
    this.clientWritePlatformService = clientWritePlatformService;
}

@Transactional
@Override
public CommandProcessingResult processCommand(final JsonCommand command) {

    return this.clientWritePlatformService.withdrawClient(command.entityId(), command);
}

}