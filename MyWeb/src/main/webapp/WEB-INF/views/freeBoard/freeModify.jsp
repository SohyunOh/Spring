<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <section>
        <div class="container">
            <div class="row">
                <div class="col-xs-12 col-md-9 write-wrap">
                        <div class="titlebox">
                            <p>수정하기</p>
                        </div>
                        
                        <form>
                            <div>
                                <label>DATE</label>
                                <p>2019-12-12</p>
                            </div>   
                            <div class="form-group">
                                <label>번호</label>
                                <input class="form-control" name='##' readonly>
                            </div>
                            <div class="form-group">
                                <label>작성자</label>
                                <input class="form-control" name='##'>
                            </div>    
                            <div class="form-group">
                                <label>제목</label>
                                <input class="form-control" name='##'>
                            </div>

                            <div class="form-group">
                                <label>내용</label>
                                <textarea class="form-control" rows="10" name='##'></textarea>
                            </div>

                            <button type="button" class="btn btn-dark">목록</button>    
                            <button type="button" class="btn btn-primary">변경</button>
                            <button type="button" class="btn btn-info">삭제</button>
                    </form>
                                    
                </div>
            </div>
        </div>
        </section>
      