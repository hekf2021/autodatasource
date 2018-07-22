package com.eck.auto.exception;
import com.eck.auto.model.vo.ResultInfoVo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler(MyException.class)
    public ResponseEntity<ResultInfoVo> DataQualityException(MyException e) {
        e.printStackTrace();
        ResultInfoVo info = new ResultInfoVo(e.getHttpCode(),e.getCode(),e.getMessage());
        return new ResponseEntity<ResultInfoVo>(info, HttpStatus.valueOf(e.getHttpCode()));

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResultInfoVo>  Exception(Exception e) {
        e.printStackTrace();
        ResultInfoVo vo = null;
        if(e instanceof NullPointerException) {
            vo = new ResultInfoVo(HttpStatus.INTERNAL_SERVER_ERROR.value(),"InternalServerError", "空指针异常");
        }else{
            vo = new ResultInfoVo(HttpStatus.INTERNAL_SERVER_ERROR.value(),"InternalServerError",e.getMessage());
        }
        return new ResponseEntity<ResultInfoVo>(vo, HttpStatus.valueOf(500));
    }


}
