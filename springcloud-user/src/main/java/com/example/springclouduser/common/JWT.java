package com.example.springclouduser.common;

/**
 * @Auther: sunyy
 * @Date: 2018/11/13 17:27
 * @Description:
 */
public class JWT {

    private String access_token;//访问令牌
    private String token_type; //令牌类型
    private String refresh_token;//更新令牌，用来获取下一次的访问令牌
    private String scope;//权限范围
    private String jti;
    private int expires_in;//过期时间单位秒
//    private Long create_time;

//    public Long getCreate_time() {
//        return create_time;
//    }
//
//    public void setCreate_time(Long create_time) {
//        this.create_time = create_time;
//    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getJti() {
        return jti;
    }

    public void setJti(String jti) {
        this.jti = jti;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }
}
