package com.example.ZuulClient.model;

import java.util.Set;

	
	
	public class Utility {

		
		private int utilityId;
		
		
		private String utilityName;
		
		
		private Set<User> utilityProviders;
		
		
		private Set<User> utilityConsumers;
		
		

		public Utility() {
			super();
		}

		
		public Utility(int utilityId, String utilityName) {
			
			this.utilityId = utilityId;
			this.utilityName = utilityName;
			
		}
		
		
		public Utility( String utilityName) {			
			
			this.utilityName = utilityName;
			
		}

		
		public Utility(int utilityId, String utilityName, Set<User> utilityProviders, Set<User> utilityConsumers) {
			super();
			this.utilityId = utilityId;
			this.utilityName = utilityName;
			this.utilityProviders = utilityProviders;
			this.utilityConsumers = utilityConsumers;
		}
		
		
		
		public int getUtilityId() {
			return utilityId;
		}

		public void setUtilityId(int utilityId) {
			this.utilityId = utilityId;
		}

		public String getUtilityName() {
			return utilityName;
		}

		public void setUtilityName(String utilityName) {
			this.utilityName = utilityName;
		}

		public Set<User> getUtilityProviders() {
			return utilityProviders;
		}

		public void setUtilityProviders(Set<User> utilityProviders) {
			this.utilityProviders = utilityProviders;
		}

		public Set<User> getUtilityConsumers() {
			return utilityConsumers;
		}

		public void setUtilityConsumers(Set<User> utilityConsumers) {
			this.utilityConsumers = utilityConsumers;
		}


		
		
	}


