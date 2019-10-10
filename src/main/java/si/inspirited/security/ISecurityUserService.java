package si.inspirited.security;

public interface ISecurityUserService {

    String validatePasswordResetToken(long id, String token);

}
