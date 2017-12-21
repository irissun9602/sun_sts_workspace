package net.skhu.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import net.skhu.dto.Article;

@Mapper
public interface ArticleMapper {
	Article findOne(int id);
	List<Article> findAll();
	void insert(Article article);
	void delete(int id);
	void update(Article article);
	
}
