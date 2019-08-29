package restaurant_cafe02;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * Servlet Filter implementation class ForcedRepatriationFilter
 */
public class ForcedRepatriationFilter implements Filter {

    /**
     * Default constructor.
     */
    public ForcedRepatriationFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		//statusの取得
        HttpSession session = ((HttpServletRequest)request).getSession(false);

        //statusの状態を判定
        if (session == null || session.getAttribute("status") != "login") {
            ((HttpServletResponse)response).
                                                sendRedirect("/w10session/loginForm.jsp");

        } else {
            chain.doFilter(request, response);
        }
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
