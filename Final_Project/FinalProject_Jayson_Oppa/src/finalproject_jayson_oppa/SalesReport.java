
package finalproject_jayson_oppa;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class SalesReport {
    private SimpleStringProperty orderNumber, date, time, subTotal, tax, total;

    public SalesReport(String orderNumber, String date, String time, String subTotal, String tax, String total) {
        this.orderNumber = new SimpleStringProperty(orderNumber);
        this.date = new SimpleStringProperty(date);
        this.time = new SimpleStringProperty(time);
        this.subTotal = new SimpleStringProperty(subTotal);
        this.tax = new SimpleStringProperty(tax);
        this.total = new SimpleStringProperty(total);
    }

    public void setOrderNumber(SimpleStringProperty orderNumber) {
        this.orderNumber = orderNumber;
    }

    public void setDate(SimpleStringProperty date) {
        this.date = date;
    }

    public void setTime(SimpleStringProperty time) {
        this.time = time;
    }

    public void setSubTotal(SimpleStringProperty subTotal) {
        this.subTotal = subTotal;
    }

    public void setTax(SimpleStringProperty tax) {
        this.tax = tax;
    }

    public void setTotal(SimpleStringProperty total) {
        this.total = total;
    }

    public String getOrderNumber() {
        return orderNumber.get();
    }

    public String getDate() {
        return date.get();
    }

    public String getTime() {
        return time.get();
    }

    public String getSubTotal() {
        return subTotal.get();
    }

    public String getTax() {
        return tax.get();
    }

    public String getTotal() {
        return total.get();
    }

    @Override
    public String toString() {
        return  "Order Number:" + orderNumber.getValue() + ",Date:" + date.getValue() + ",Time:" + time.getValue() + ",SubTotal:" + subTotal.getValue() + ",Tax:" + tax.getValue() + ",Total:" + total.getValue();
    }
}
