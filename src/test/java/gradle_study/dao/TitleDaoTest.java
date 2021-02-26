package gradle_study.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import gradle_study.dao.impl.TitleDaoImpl;
import gradle_study.dto.Title;

public class TitleDaoTest {
	private static final String con = null;
	private TitleDao dao = TitleDaoImpl.getIntance();

	@Test
	public void testSelectTitleByAll() {
		List<Title> list = dao.selectTitleByAll();
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);
	}

	@Test
	public void testSelecTitleByNo() {
		System.out.println("testSelectTitleByNo()");
		Title selectTitle = dao.selecTitleByNo(new Title(1));
		Assert.assertNotNull(selectTitle);
		System.out.println(selectTitle);
	}

	@Test
	public void testInsertTitle() {
		System.out.println("testInsertTitle()");
		Title newTitle = new Title(6, "인턴");
		int res = dao.insertTitle(newTitle);
		Assert.assertEquals(1, res);
	}

	@Test
	public void testUpdateTitle() {
		System.out.println("testUpdateTitle()");
		Title upTitle = new Title(6, "계약직");
		int res = dao.updateTitle(upTitle);
		Assert.assertEquals(1, res);

		System.out.println(dao.selecTitleByNo(upTitle));
	}

	@Test
	public void testDeleteTitle() {
		System.out.println("testdeleteTitle()");
		Title deTitle = new Title(6);
		int res = dao.deleteTitle(deTitle);
		Assert.assertEquals(1, res);

		System.out.println(dao.selecTitleByNo(deTitle));
	}

}
