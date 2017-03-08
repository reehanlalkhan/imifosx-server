INSERT INTO m_charge(id, name, currency_code, charge_applies_to_enum, charge_time_enum, charge_calculation_enum, charge_payment_mode_enum, amount, fee_on_day, fee_interval, fee_on_month, is_penalty, is_active, is_deleted, min_cap, max_cap, fee_frequency, income_or_liability_account_id) VALUES
(1, 'Service Charge', 'INR', 1, 8, 1, 0, 0.000000, NULL, NULL, NULL, 0, 1, 0, NULL, NULL, NULL, NULL);


INSERT INTO `m_portfolio_command_source` (`id`, `action_name`, `entity_name`, `office_id`, `group_id`, `client_id`, `loan_id`, `savings_account_id`, `api_get_url`, `resource_id`, `subresource_id`, `command_as_json`, `maker_id`, `made_on_date`, `checker_id`, `checked_on_date`, `processing_result_enum`, `product_id`, `transaction_id`) VALUES
(1, 'CREATE', 'CHARGE', NULL, NULL, NULL, NULL, NULL, '/charges/template', 1, NULL, '{"chargeAppliesTo":1,"name":"Service Charge","currencyCode":"INR","chargeTimeType":8,"chargeCalculationType":1,"chargePaymentMode":0,"amount":"0.000000","active":true,"locale":"en","monthDayFormat":"dd MMM"}', 1, '2017-03-01 10:10:10', NULL, NULL, 1, NULL, NULL);
