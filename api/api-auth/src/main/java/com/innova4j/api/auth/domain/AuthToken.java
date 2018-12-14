/**
 * 
 */
package com.innova4j.api.auth.domain;

import java.time.LocalDateTime;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;

import com.innova4j.api.commons.domain.Converter;

/**
 * @author innova4j-team
 *
 */
@Entity
@Table(name = "auth_token")
public class AuthToken {

	@EmbeddedId
	private AuthTokenId id;
	@NotNull
	private String token;
	@NotNull
	private String authentication;
	@NotNull
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private LocalDateTime expiresAt;

	/**
	 * @return the id
	 */
	public AuthTokenId getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(AuthTokenId id) {
		this.id = id;
	}

	/**
	 * @return the token
	 */
	public OAuth2AccessToken getToken() {
		try {
			return Converter.deserialize(token);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * @param token the token to set
	 */
	public void setToken(OAuth2AccessToken token) {
		this.token = Converter.serialize(token);
	}

	/**
	 * @return the authentication
	 */
	public OAuth2Authentication getAuthentication() {
		try {
			return Converter.deserialize(authentication);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * @param authentication the authentication to set
	 */
	public void setAuthentication(OAuth2Authentication authentication) {
		this.authentication = Converter.serialize(authentication);
	}

	/**
	 * @return the expiresAt
	 */
	public LocalDateTime getExpiresAt() {
		return expiresAt;
	}

	/**
	 * @param expiresAt the expiresAt to set
	 */
	public void setExpiresAt(LocalDateTime expiresAt) {
		this.expiresAt = expiresAt;
	}

	public boolean isExpired() {
		LocalDateTime now = LocalDateTime.now();
		return this.expiresAt == null || this.expiresAt.isBefore(now);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AuthToken [id=" + id + ", token=" + token + ", authentication=" + authentication + ", expiresAt="
				+ expiresAt + "]";
	}

}