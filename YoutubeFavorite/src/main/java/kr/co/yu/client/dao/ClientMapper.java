package kr.co.yu.client.dao;

import java.util.List;

import kr.co.yu.model.GalleryVO;
import kr.co.yu.model.YoutubeVO;

public interface ClientMapper {
	public List<YoutubeVO> getList();
	public List<GalleryVO> getGalleryList();
	public GalleryVO getGalleryDetail(int g_no);
}
