package s.w.s.board.service;

import java.util.List;
import java.util.Map;

import s.w.s.board.vo.ArticleVO;

public interface BoardService {
	public List<ArticleVO> listArticles() throws Exception;
}
