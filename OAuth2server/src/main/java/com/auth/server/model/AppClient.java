package com.auth.server.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="oauth_client_details")
public class AppClient {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private String id;
	
	@Column(name="client_id")
	private String clientId;
	
	@Column(name="client_secret")
	private String clientSecret;
	
	@Column(name="access_token_validity")
	private int accessTokenValidity;
	
	@Column(name="scope")
	private String scope;
	
	@Column(name="authorities")
	private String authorities;
	
	@Column(name="authorized_grant_types")
	private String authorizedGrantTypes;
	
	@Column(name="refresh_token_validity")
	private int refreshTokenValidity;

	@Column(name="resource_ids")
	private String resourceIds;
	
	@Column(name="web_server_redirect_uri")
	private String webServerRedirectUri;
	
	@Column(name="autoapprove")
	private String autoApprove;
	
	@Column(name="additional_information")
	private String addInfo;

	public AppClient() {
		super();
	}

	

	public AppClient(String clientId, String clientSecret, int accessTokenValidity, String scope, String authorities,
			String authorizedGrantTypes, int refreshTokenValidity, String resourceIds) {
		super();
		this.clientId = clientId;
		this.clientSecret = clientSecret;
		this.accessTokenValidity = accessTokenValidity;
		this.scope = scope;
		this.authorities = authorities;
		this.authorizedGrantTypes = authorizedGrantTypes;
		this.refreshTokenValidity = refreshTokenValidity;
		this.resourceIds=resourceIds;
	}
	
	public AppClient(String clientId, String clientSecret, int accessTokenValidity, String scope, String authorities,
			String authorizedGrantTypes, int refreshTokenValidity, String resourceIds,String redirectUri) {
		super();
		this.clientId = clientId;
		this.clientSecret = clientSecret;
		this.accessTokenValidity = accessTokenValidity;
		this.scope = scope;
		this.authorities = authorities;
		this.authorizedGrantTypes = authorizedGrantTypes;
		this.refreshTokenValidity = refreshTokenValidity;
		this.resourceIds=resourceIds;
		this.webServerRedirectUri=redirectUri;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	public int getAccessTokenValidity() {
		return accessTokenValidity;
	}

	public void setAccessTokenValidity(int accessTokenValidity) {
		this.accessTokenValidity = accessTokenValidity;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getAuthorities() {
		return authorities;
	}

	public void setAuthorities(String authorities) {
		this.authorities = authorities;
	}

	public String getAuthorizedGrantTypes() {
		return authorizedGrantTypes;
	}

	public void setAuthorizedGrantTypes(String authorizedGrantTypes) {
		this.authorizedGrantTypes = authorizedGrantTypes;
	}

	public int getRefreshTokenValidity() {
		return refreshTokenValidity;
	}

	public void setRefreshTokenValidity(int refreshTokenValidity) {
		this.refreshTokenValidity = refreshTokenValidity;
	}

	public String getResourceId() {
		return resourceIds;
	}

	public void setResourceId(String resourceId) {
		this.resourceIds = resourceId;
	}



	public String getResourceIds() {
		return resourceIds;
	}



	public void setResourceIds(String resourceIds) {
		this.resourceIds = resourceIds;
	}



	public String getWebServerRedirectUri() {
		return webServerRedirectUri;
	}



	public void setWebServerRedirectUri(String webServerRedirectUri) {
		this.webServerRedirectUri = webServerRedirectUri;
	}



	public String getAutoApprove() {
		return autoApprove;
	}



	public void setAutoApprove(String autoApprove) {
		this.autoApprove = autoApprove;
	}



	public String getAddInfo() {
		return addInfo;
	}



	public void setAddInfo(String addInfo) {
		this.addInfo = addInfo;
	}
	
	
	
	
	
	
}
