
package finalproject_jayson_oppa;

public class makeOrder {
    private String orderNumber;
    private String date;
    private String time;
    private String subTotal;
    private String tax;
    private String total;

    public makeOrder(String orderNumber, String date, String time, String subTotal, String tax, String total) {
        this.orderNumber = orderNumber;
        this.date = date;
        this.time = time;
        this.subTotal = subTotal;
        this.tax = tax;
        this.total = total;
    } 
    
    public String toFileString(){
        return orderNumber + "," + date + "," + time + "," + subTotal + "," + tax + "," + total;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setSubTotal(String subTotal) {
        this.subTotal = subTotal;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getSubTotal() {
        return subTotal;
    }

    public String getTax() {
        return tax;
    }

    public String getTotal() {
        return total;
    }
}
