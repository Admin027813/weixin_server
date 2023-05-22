package weixin_server.my.exception;

import lombok.Data;

@Data
public class ExceptionThrows extends RuntimeException{
    private String msg;
    private int code = 500;
    public ExceptionThrows(String msg) {
        super(msg);
         this.msg = msg;
    }
    public ExceptionThrows(String msg, Throwable e) {
         super(msg, e);
         this.msg = msg;
         }
    public ExceptionThrows(String msg, int code) {
         super(msg);
         this.msg = msg;
         this.code = code;
        }
    public ExceptionThrows(String msg, int code, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
         }
}
