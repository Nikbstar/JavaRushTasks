package com.javarush.task.task19.task1903;

/* 
Адаптация нескольких интерфейсов
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<>();

    public static void main(String[] args) {

    }

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static class IncomeDataAdapter implements Customer, Contact {

        private final IncomeData data;

        public IncomeDataAdapter (IncomeData data) {
            this.data = data;
        }

        @Override
        public String getCompanyName() {
            return this.data.getCompany();
        }

        @Override
        public String getCountryName() {
            return countries.get(this.data.getCountryCode());
        }

        @Override
        public String getName() {
            return String.format("%s, %s", this.data.getContactLastName(), this.data.getContactFirstName());
        }

        @Override
        public String getPhoneNumber() {
            StringBuilder sb = new StringBuilder();
            String number = String.format("%010d", this.data.getPhoneNumber());
            sb.append("+").append(this.data.getCountryPhoneCode()).append("(")
                    .append(number.substring(0, 3)).append(")")
                    .append(number.substring(3, 6)).append("-")
                    .append(number.substring(6, 8)).append("-")
                    .append(number.substring(8));
            return sb.toString();
        }
    }

    public interface IncomeData {
        String getCountryCode();        //example UA

        String getCompany();            //example JavaRush Ltd.

        String getContactFirstName();   //example Ivan

        String getContactLastName();    //example Ivanov

        int getCountryPhoneCode();      //example 38

        int getPhoneNumber();           //example 501234567
    }

    public interface Customer {
        String getCompanyName();        //example JavaRush Ltd.

        String getCountryName();        //example Ukraine
    }

    public interface Contact {
        String getName();               //example Ivanov, Ivan

        String getPhoneNumber();        //example +38(050)123-45-67
    }
}