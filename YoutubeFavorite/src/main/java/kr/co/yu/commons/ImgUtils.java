package kr.co.yu.commons;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.springframework.util.FileCopyUtils;

import kr.co.yu.model.GalleryVO;

public class ImgUtils {
	public static String saveImgAndMakeThumb(Class<?> cls, GalleryVO vo) {
		String g_path = "";
		
		try {
			String contextPath = cls.getClassLoader().getResource("").getPath();
			String fullPath = URLDecoder.decode(contextPath, "UTF-8");
			String pathArr[] = fullPath.split("WEB-INF/classes/");
			String targetPath = pathArr[0] + "resources/img/";
			String originalFileName = vo.getImg().getOriginalFilename();
			String extension = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
						
			System.out.println(contextPath);
			System.out.println(fullPath);
			System.out.println(pathArr[0]);
			System.out.println(targetPath);
			System.out.println(originalFileName);
			System.out.println(extension);
			
			
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd", Locale.KOREA);
			
			String bigImgpath = targetPath + sdf.format(date); //연도/월/일/				
			
			System.out.println(bigImgpath);
			
			File path = new File(bigImgpath);
			if(!path.exists()) { // path의 주소경로가 실제로 있는지 물어봄
				path.mkdirs(); // path 경로를 만듬
			}
			
			UUID uuid = UUID.randomUUID();
			String bigImgName = uuid.toString() + "." + extension;
			
			File bigImg = new File(bigImgpath, bigImgName); //targetPath와 이미지 풀네임을 합쳐줌
			FileCopyUtils.copy(vo.getImg().getBytes(), bigImg); //Spring에서 제공, img경로의 파일명으로 실제로 만들어줌
			
			//썸네일 경로 만들기
			String thumbImgPath = targetPath + "thumb/" + sdf.format(date);
			path = new File(thumbImgPath);
			if(!path.exists()) {
				path.mkdirs();
			}
			
			//썸네일 생성
			BufferedImage sourceImg = ImageIO.read(bigImg); // 저장된 bigImg를 불러옴
			BufferedImage destImg = Scalr.resize(sourceImg, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_TO_HEIGHT, 100);
			File thumbImg = new File(thumbImgPath, bigImgName);
			ImageIO.write(destImg, extension, thumbImg);
			
			g_path = sdf.format(date) + "/" + bigImgName; 
					
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return g_path;
	}
}
