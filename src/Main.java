import exception.WrongLoginException;
import exception.WrongPasswordException;

public class Main {

    private static final String VALIDATE_PATTERN = "^[a-zA-Z0-9-_]+$";
    public static void main(String[] args) {

        check("DyiT_34_NfgReY537_", "4_G_43_27BnmRuI", "4_G_43_27BnmRuI");
        check("ШЛиуК_56_Зт", "4_G_43_27BnmRuI", "4_G_43_27BnmRuI");
        check("ErtinF_56_67_JkLcV_45D_rE_54_67_ErtS_89", "4_G_43_27BnmRuI", "4_G_43_27BnmRuI");
        check("DyiT_34_NfgReY537_", "ШЛиуК_56_Зт", "ШЛиуК_56_Зт");
        check("DyiT_34_NfgReY537_", "4_G_43_27BnmRuI", "4_G_43_27NnmRuI");
        check("ErtinF_56_67_JkLcV_45D_rE_54_67_ErtS_8", "ШЛиуК_56_Зт", "4_G_43_27NnmRuI");


    }

    private static boolean check(String login, String password, String confirmPassword) {
        boolean isValid = true;

        try {
            checkLogin(login);
            checkPassword(password, confirmPassword);
        } catch (WrongLoginException e) {
            System.out.println("Ошибка с введенным логином. " + e.getMessage());
            isValid = false;
        } catch (WrongPasswordException e) {
            System.out.println("Ошибка с введенным паролем. " + e.getMessage());
            isValid = false;
        }

        if (isValid) {
            System.out.println("Логин и пароль корректные");
        }

        return isValid;
    }
    private static void checkLogin(String login) throws WrongLoginException {
        if (!login.matches(VALIDATE_PATTERN)) {
            throw new WrongLoginException("Логин должен содержать в себе только латинские буквы, " +
                    "цифры и знак подчеркивания.");
        } else if (login.length() > 20) {
            throw new WrongLoginException("Логин не должен содержать в себе более 20 символов.");
        }
    }

    private static void checkPassword(String password, String confirmPassword) throws WrongPasswordException {
        if (!password.matches(VALIDATE_PATTERN)) {
            throw new WrongPasswordException("Пароль должен содержать в себе только латинские буквы, " +
                    "цифры и знак подчеркивания.");
        } else if (password.length() > 20) {
            throw new WrongPasswordException("Пароль не должен содержать в себе более 20 символов.");
        } else if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли должны совпадать.");
            
        }
    }
}