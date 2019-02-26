/**
 * 
 */
package org.apache.fineract.portfolio.servicecharge.util.daterange;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.lang.StringUtils;
import org.apache.fineract.accounting.journalentry.api.DateParam;
import org.apache.fineract.infrastructure.core.service.DateUtils;
import org.apache.fineract.portfolio.servicecharge.constants.ServiceChargeApiConstants;
import org.apache.fineract.portfolio.servicecharge.exception.ServiceChargeException;
import org.apache.fineract.portfolio.servicecharge.exception.ServiceChargeException.SERVICE_CHARGE_EXCEPTION_REASON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A date range object that will implement the ServiceChargeDateRange This class
 * will have all the quarterly
 *
 */
enum QuarterlyServiceChargeDateRange implements ServiceChargeDateRange, ServiceChargeApiConstants {
    Q1(1, "01 Jan ", "31 Mar "), Q2(2, "01 Apr ", "30 Jun "), Q3(3, "01 Jul ", "30 Sep "), Q4(4, "01 Oct ", "31 Dec ");

    private final static Logger logger = LoggerFactory.getLogger(QuarterlyServiceChargeDateRange.class);
    private final Integer id;
    private final String fromDate;
    private final String toDate;
    private int year;

    private final String dateFormatString = "dd MMMM yyyy";

    /**
     * 
     */
    private QuarterlyServiceChargeDateRange(final Integer id, final String fromDate, final String toDate) {
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

    public static ServiceChargeDateRange getCurrentQuarter(String monthCode, int year) {
        ServiceChargeDateRange q = null;
        if (!StringUtils.isEmpty(monthCode)) {
            final String qStr = monthCode.toUpperCase();
            switch (qStr) {
                case JANUARY:
                case FEBRUARY:
                case MARCH:
                    q = Q1;
                break;
                case APRIL:
                case MAY:
                case JUNE:
                    q = Q2;
                break;
                case JULY:
                case AUGUST:
                case SEPTEMBER:
                    q = Q3;
                break;
                case OCTOBER:
                case NOVEMBER:
                case DECEMBER:
                    q = Q4;
                break;
                default:
                    // Throw exception to say what was expected
                    throw new ServiceChargeException(SERVICE_CHARGE_EXCEPTION_REASON.SC_INVALID_MONTH_CODE, null);
            }
        } else {
            Calendar c = Calendar.getInstance(Locale.getDefault());
            int month = c.get(Calendar.MONTH);

            q = (month >= Calendar.JANUARY && month <= Calendar.MARCH) ? Q1
                    : (month >= Calendar.APRIL && month <= Calendar.JUNE) ? Q2
                            : (month >= Calendar.JULY && month <= Calendar.SEPTEMBER) ? Q3 : Q4;
        }
        if (year != 0) {
            q.setYear(year);
        }
        logger.info("QuarterlyServiceChargeDateRange.getCurrentQuarter(): derived quarter::" + q);
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
        return ServiceChargeCalculatoinMethod.QUARTERLY;
    }
}
