
package org.ideoholic.imifosx.portfolio.servicecharge.data;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.ideoholic.imifosx.accounting.glaccount.data.GLAccountData;
import org.ideoholic.imifosx.infrastructure.core.data.EnumOptionData;
import org.ideoholic.imifosx.organisation.monetary.data.CurrencyData;
import org.ideoholic.imifosx.portfolio.charge.data.ChargeData;
import org.joda.time.MonthDay;

/**
 * Data object for service charge data - extending charge data
 */
public class ServiceChargeData extends ChargeData {

	protected ServiceChargeData(final Long id, final String name, final BigDecimal amount, final CurrencyData currency,
			final EnumOptionData chargeTimeType, final EnumOptionData chargeAppliesTo,
			final EnumOptionData chargeCalculationType, final EnumOptionData chargePaymentMode, final boolean penalty,
			final boolean active, final Collection<CurrencyData> currencyOptions,
			final List<EnumOptionData> chargeCalculationTypeOptions, final List<EnumOptionData> chargeAppliesToOptions,
			final List<EnumOptionData> chargeTimeTypeOptions, final List<EnumOptionData> chargePaymentModeOptions,
			final List<EnumOptionData> loansChargeCalculationTypeOptions,
			final List<EnumOptionData> loansChargeTimeTypeOptions,
			final List<EnumOptionData> savingsChargeCalculationTypeOptions,
			final List<EnumOptionData> savingsChargeTimeTypeOptions,
			final List<EnumOptionData> clientChargeCalculationTypeOptions,
			final List<EnumOptionData> clientChargeTimeTypeOptions, final MonthDay feeOnMonthDay,
			final Integer feeInterval, final BigDecimal minCap, final BigDecimal maxCap,
			final EnumOptionData feeFrequency, final List<EnumOptionData> feeFrequencyOptions,
			final GLAccountData account, final Map<String, List<GLAccountData>> incomeOrLiabilityAccountOptions) {

		super(id, name, amount, currency, chargeTimeType, chargeAppliesTo, chargeCalculationType, chargePaymentMode,
				penalty, active, currencyOptions, chargeCalculationTypeOptions, chargeAppliesToOptions,
				chargeTimeTypeOptions, chargePaymentModeOptions, loansChargeCalculationTypeOptions,
				loansChargeTimeTypeOptions, savingsChargeCalculationTypeOptions, savingsChargeTimeTypeOptions,
				clientChargeCalculationTypeOptions, clientChargeTimeTypeOptions, feeOnMonthDay, feeInterval, minCap,
				maxCap, feeFrequency, feeFrequencyOptions, account, incomeOrLiabilityAccountOptions);
	}

}