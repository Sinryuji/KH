package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import board.domain.BoardVO;
import board.service.BoardService;
import spring.AuthInfo;

@Controller
@SessionAttributes("boardVO")
public class BoardController {

	private BoardService boardService;

	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}

	@RequestMapping(value = "/board/list")
	public String list(Model model) {
//		이렇게 할거면 HttpServletRequest와 HttpSession을 매개변수로 받아야함!! 근데 이거보다 인터셉트가 훨씬 편한듯!
//		session = request.getSession(false);
//		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
//		if(authInfo == null) {
//			return "redirect:/main"; 
//		}
		model.addAttribute("boardList", boardService.list());
		return "board/list";
	}

	@RequestMapping(value = "/board/read/{seq}")
	public String read(Model model, @PathVariable int seq) {
		model.addAttribute("boardVO", boardService.read(seq));
		return "board/read";
	}

	// 새 글 작성을 위한 요청을 처리
	@RequestMapping(value = "/board/write", method = RequestMethod.GET)
	public String write(Model model, HttpServletRequest request, HttpSession session) {
		session = request.getSession(false);
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		if(authInfo != null) {
		String name = authInfo.getName();
		BoardVO boardVO = new BoardVO();
		boardVO.setWriter(name);
		model.addAttribute("boardVO", boardVO);
		}
		else {
			model.addAttribute("boardVO", new BoardVO());
		}
		return "board/write";
	}

	// 새 글 등록을 위한 요청을 처리
	@RequestMapping(value = "/board/write", method = RequestMethod.POST)
	public String write(@Valid BoardVO boardVO, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "board/write";
		}
		boardService.write(boardVO);
		return "redirect:board/list";
	}

	@RequestMapping(value = "/board/edit/{seq}", method = RequestMethod.GET)
	public String edit(@PathVariable int seq, Model model) {
		BoardVO boardVO = boardService.read(seq);
		model.addAttribute("boardVO", boardVO);
		return "/board/edit";
	}

	@RequestMapping(value = "/board/edit/{seq}", method = RequestMethod.POST)
	public String edit(@Valid @ModelAttribute BoardVO boardVO, BindingResult result, int pwd, SessionStatus sessionStatus, Model model) {
		if (result.hasErrors()) {
			return "/board/edit";
		} else {
			if (boardVO.getPassword() == pwd) {
				boardService.edit(boardVO);
				sessionStatus.setComplete();
				return "redirect:/board/list";
			}
		}
		model.addAttribute("msg", "비밀번호가 일치하지 않습니다.");
		return "/board/edit";
	}
	
	//글 삭제 요청을 처리할 메서드
	@RequestMapping(value = "/board/delete/{seq}", method=RequestMethod.GET)
	public String delete(@PathVariable int seq, Model model) {
		model.addAttribute("seq", seq);
		return "/board/delete";
	}
	
	@RequestMapping(value = "/board/delete", method=RequestMethod.POST)
	public String delete(int seq, int pwd, Model model) {
		int rowCount;
		BoardVO boardVO = new BoardVO();
		boardVO.setSeq(seq);
		boardVO.setPassword(pwd);
		
		rowCount = boardService.delete(boardVO);
		
		if(rowCount == 0) {
			model.addAttribute("seq", seq);
			model.addAttribute("msg", "비밀번호가 일치하지 않습니다.");
			return "/board/delete";
		}
		else {
			return "redirect:/board/list";
		}
	}
}
