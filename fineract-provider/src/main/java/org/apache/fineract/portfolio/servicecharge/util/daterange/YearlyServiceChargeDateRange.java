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
package org.apache.fineract.portfolio.servicecharge.util.daterange;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.apache.fineract.accounting.journalentry.api.DateParam;
import org.apache.fineract.infrastructure.core.service.DateUtils;
import org.apache.fineract.portfolio.servicecharge.constants.ServiceChargeApiConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A date range object that will implement the ServiceChargeDateRange This class
 * will have all the quarterly
 *
 */
enum YearlyServiceChargeDateRange implements ServiceChargeDateRange, ServiceChargeApiConstants {
    YEARLY(1, "01 Jan ", "31 Dec ");

    private final static Logger logger = LoggerFactory.getLogger(YearlyServiceChargeDateRange.class);
    private final Integer id;
    private final String fromDate;
    private final String toDate;
    private int year;

    private final String dateFormatString = "dd MMMM yyyy";

    /**
     * 
     */
    private YearlyServiceChargeDateRange(final Integer id, final String fromDate, final String toDate) {
        this.id = id;
        this.fromDate = fromDate;
        this.toDate = toDate;
        Calendar c = Calendar.getInstance(Locale.getDefault());
        this.year = c.get(Calendar.YEAR);
    }

    public String getFromDateString(int year) {
        return fromDate + year;
    }

    public String getToDateString(int year) {
        return toDate + year;
    }

    public String getDateFormatString() {
        return dateFormatString;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.apache.fineract.portfolio.servicecharge.util.daterange.
     * ServiceChargeDateRange#getId()
     */
    @Override
    public Integer getId() {
        return id;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.apache.fineract.portfolio.servicecharge.util.daterange.
     * ServiceChargeDateRange#getName()
     */
    @Override
    public String getName() {
        return name();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.apache.fineract.portfolio.servicecharge.util.daterange.
     * ServiceChargeDateRange#getFromDateStringForCurrentYear()
     */
    @Override
    public String getFromDateStringForCurrentYear() {
        return getFromDateString(Calendar.getInstance().get(Calendar.YEAR));
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.apache.fineract.portfolio.servicecharge.util.daterange.
     * ServiceChargeDateRange#getToDateStringForCurrentYear()
     */
    @Override
    public String getToDateStringForCurrentYear() {
        return getToDateString(Calendar.getInstance().get(Calendar.YEAR));
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.apache.fineract.portfolio.servicecharge.util.daterange.
     * ServiceChargeDateRange#getFormattedFromDateString()
     */
    @Override
    public String getFormattedFromDateString() {
        return DateUtils.formatToSqlDate(getFromDateForCurrentYear());
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.apache.fineract.portfolio.servicecharge.util.daterange.
     * ServiceChargeDateRange#getFormattedToDateString()
     */
    @Override
    public String getFormattedToDateString() {
        return DateUtils.formatToSqlDate(getToDateForCurrentYear());
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.apache.fineract.portfolio.servicecharge.util.daterange.
     * ServiceChargeDateRange#getFromDateForCurrentYear()
     */
    @Override
    public Date getFromDateForCurrentYear() {
        return getFromDate(getYear());
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.apache.fineract.portfolio.servicecharge.util.daterange.
     * ServiceChargeDateRange#getToDateForCurrentYear()
     */
    @Override
    public Date getToDateForCurrentYear() {
        return getToDate(getYear());
    }

    public Date getFromDate(int year) {
        String locale = Locale.getDefault().toString();
        String fullDateString = getFromDateString(year);
        return new DateParam(fullDateString).getDate("Service Data Entries From Date", getDateFormatString(), locale);
    }

    public Date getToDate(int year) {
        String locale = Locale.getDefault().toString();
        String fullDateString = getToDateString(year);
        return new DateParam(fullDateString).getDate("Service Data Entries To Date", getDateFormatString(), locale);
    }

    public static ServiceChargeDateRange getCurrentYear(String monthCode, int year) {
        ServiceChargeDateRange q = YEARLY;
        if (year != 0) {
            q.setYear(year);
        }
        logger.debug("YearlyServiceChargeDateRange.getCurrentQuarter(): derived quarter::" + q);
        return q;
    }

    @Override
    public String toString() {
        return name().toString();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.apache.fineract.portfolio.servicecharge.util.daterange.
     * ServiceChargeDateRange#setYear()
     */
    @Override
    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return this.year;
    }

    public ServiceChargeCalculatoinMethod getChargeCalculationMethodEnum() {
        return ServiceChargeCalculatoinMethod.YEARLY;
    }

    @Override
    public int getDateRangeDurationMonths() {
        // TODO Auto-generated method stub
        return 12;
    }
}
