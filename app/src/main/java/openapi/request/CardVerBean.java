package openapi.request;

/**
 * Copyright (C), 2018-2019, 商米科技有限公司
 * FileName: CardVerBean
 *
 * @author: liuzhicheng
 * Date: 19-10-17
 * Description:
 * History:
 */
public class CardVerBean {

    /**
     * biz_id : 5456897876546767654
     * identity_param : {"identity_type":"CERT","cert_type":"IDCARD","cert_name":"张*","cert_no":"34113********24","user_id":"208810*****91410"}
     * metainfo : {"apdidToken ":"0 / 5 NLJUTQBwgg8YiPXyMs / 7 gUtUxDpFEzVF46QQ029qmqXn2aDlQYQEB "}
     * extern_param : {}
     */

    public String biz_id;
    public IdentityParamBean identity_param;
    public String metainfo;

    public String getBiz_id() {
        return biz_id;
    }

    public void setBiz_id(String biz_id) {
        this.biz_id = biz_id;
    }

    public IdentityParamBean getIdentity_param() {
        return identity_param;
    }

    public void setIdentity_param(IdentityParamBean identity_param) {
        this.identity_param = identity_param;
    }



    public static class IdentityParamBean {
        /**
         * identity_type : CERT
         * cert_type : IDCARD
         * cert_name : 张*
         * cert_no : 34113********24
         * user_id : 208810*****91410
         */

        public String identity_type;
        public String cert_type;
        public String cert_name;
        public String cert_no;
        public String user_id;

        public String getIdentity_type() {
            return identity_type;
        }

        public void setIdentity_type(String identity_type) {
            this.identity_type = identity_type;
        }

        public String getCert_type() {
            return cert_type;
        }

        public void setCert_type(String cert_type) {
            this.cert_type = cert_type;
        }

        public String getCert_name() {
            return cert_name;
        }

        public void setCert_name(String cert_name) {
            this.cert_name = cert_name;
        }

        public String getCert_no() {
            return cert_no;
        }

        public void setCert_no(String cert_no) {
            this.cert_no = cert_no;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }
    }


}
