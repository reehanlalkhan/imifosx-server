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
package org.ideoholic.imifosx.accounting.common;

import java.util.List;
import java.util.Map;

import org.ideoholic.imifosx.accounting.glaccount.data.GLAccountData;
import org.ideoholic.imifosx.infrastructure.core.data.EnumOptionData;

public interface AccountingDropdownReadPlatformService {

    public List<EnumOptionData> retrieveGLAccountTypeOptions();

    public List<EnumOptionData> retrieveGLAccountUsageOptions();

    public List<EnumOptionData> retrieveJournalEntryTypeOptions();

    public List<EnumOptionData> retrieveAccountingRuleTypeOptions();

    public Map<String, List<GLAccountData>> retrieveAccountMappingOptionsForLoanProducts();

    public Map<String, List<GLAccountData>> retrieveAccountMappingOptionsForSavingsProducts();

    public Map<String, List<GLAccountData>> retrieveAccountMappingOptionsForCharges();

    public Map<String, List<GLAccountData>> retrieveAccountMappingOptions();

}