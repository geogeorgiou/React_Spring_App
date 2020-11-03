package gr.dataverse.react.spring.json;

public class JwtRequest {
    String id;
    String issuer;
    String subject;
    long ttlMillis;

    public JwtRequest(String id, String issuer, String subject, long ttlMillis) {
        this.id = id;
        this.issuer = issuer;
        this.subject = subject;
        this.ttlMillis = ttlMillis;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public long getTtlMillis() {
        return ttlMillis;
    }

    public void setTtlMillis(long ttlMillis) {
        this.ttlMillis = ttlMillis;
    }
}
