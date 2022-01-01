package nazeem.web.restcontroller;

import nazeem.web.repository.IProductRepository;
import nazeem.web.repository.IProductTypeRepository;
import nazeem.web.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardRestController {

    @Autowired
    private IProductRepository productRepository;

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IProductTypeRepository productTypeRepository;

    @GetMapping("/statistics")
    public HashMap<String, Object> getDashboardStatistics(){
        long lProductCount = productRepository.count();
        long lProductTypeCount = productTypeRepository.count();
        long lUserCount = userRepository.count();
        long lVisitorsCount = 0;

        HashMap<String, Object> map = new HashMap<>();
        map.put("count_product", lProductCount);
        map.put("count_producttype", lProductTypeCount);
        map.put("count_user", lUserCount);
        map.put("count_visitors", lVisitorsCount);
        return map;
    }

}

