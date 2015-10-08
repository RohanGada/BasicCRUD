package com.example.rohan.basiccrud;

public class Vendors {
    private int _id;
    private String _vendorname;
    private String _vendoraddress;

    public Vendors() {
    }

    public Vendors( String _vendoraddress, String _vendorname) {
        this._vendoraddress = _vendoraddress;
        this._vendorname = _vendorname;
    }

    public String get_vendoraddress() {
        return _vendoraddress;
    }

    public void set_vendoraddress(String _vendoraddress) {
        this._vendoraddress = _vendoraddress;
    }

    public String get_vendorname() {
        return _vendorname;
    }

    public void set_vendorname(String _vendorname) {
        this._vendorname = _vendorname;
    }
}
