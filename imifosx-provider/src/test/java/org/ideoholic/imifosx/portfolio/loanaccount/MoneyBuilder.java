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
package org.ideoholic.imifosx.portfolio.loanaccount;

import java.math.BigDecimal;

import org.ideoholic.imifosx.organisation.monetary.domain.MonetaryCurrency;
import org.ideoholic.imifosx.organisation.monetary.domain.Money;

public class MoneyBuilder {

    private MonetaryCurrency currencyDetail = new MonetaryCurrencyBuilder().build();
    private BigDecimal newAmount = BigDecimal.ZERO;

    public Money build() {
        return Money.of(this.currencyDetail, this.newAmount);
    }

    public MoneyBuilder with(final MonetaryCurrency withDetail) {
        this.currencyDetail = withDetail;
        return this;
    }

    public MoneyBuilder with(final String withAmount) {
        this.newAmount = BigDecimal.valueOf(Double.valueOf(withAmount));
        return this;
    }
}