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
				// URLEncoder.encode(String s, String enc) : Ư�� ���ڵ� ü�踦 ����Ͽ� ���ڿ��� 
				// application / x-www-form-urlencoded �������� ��ȯ�մϴ�.
				// �� �޼���� ������ ���ڵ� ü�踦 ����Ͽ� �������� ���� ���ڿ� ���� ����Ʈ�� �����ɴϴ�.
				this.imageFileName = URLEncoder.encode(imageFileName, "UTF-8");
			}
			// ��� �� ���ڵ��� �������� �ʴ� ��� ����ó��
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
