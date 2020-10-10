package s.w.s.board.vo;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Date;

public class ImageVO {
	private int imageFileNO;
	private String imageFileName;
	private Date regDate;
	private int articleNO;
	
	
	public int getImageFileNO() {
		return imageFileNO;
	}
	public void setImageFileNO(int imageFileNO) {
		this.imageFileNO = imageFileNO;
	}
	public String getImageFileName() {
		return imageFileName;
	}
	public void setImageFileName(String imageFileName) {
		try {
			if(imageFileName != null && imageFileName.length() != 0) {
				// URLEncoder.encode(String s, String enc) : 특정 인코딩 체계를 사용하여 문자열을 
				// application / x-www-form-urlencoded 형식으로 변환합니다.
				// 이 메서드는 제공된 인코딩 체계를 사용하여 안전하지 않은 문자에 대한 바이트를 가져옵니다.
				this.imageFileName = URLEncoder.encode(imageFileName, "UTF-8");
			}
			// 명명 된 인코딩이 지원되지 않는 경우 예외처리
		}catch(UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getArticleNO() {
		return articleNO;
	}
	public void setArticleNO(int articleNO) {
		this.articleNO = articleNO;
	}
	
	
}
