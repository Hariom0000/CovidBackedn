package com.covid19.covid.domainObjects;

public class Province {
   private String province;
   private Integer confirmed;
   private Integer recovered;
   private Integer deaths;
   private Integer active;

   public String getProvince() {
       return province;
   }

   public void setProvince(String province) {
       this.province = province;
   }

   public Integer getConfirmed() {
       return confirmed;
   }

   public void setConfirmed(Integer confirmed) {
       this.confirmed = confirmed;
   }

   public Integer getRecovered() {
       return recovered;
   }

   public void setRecovered(Integer recovered) {
       this.recovered = recovered;
   }

   public Integer getDeaths() {
       return deaths;
   }

   public void setDeaths(Integer deaths) {
       this.deaths = deaths;
   }

   public Integer getActive() {
       return active;
   }

   public void setActive(Integer active) {
       this.active = active;
   }
   
}
