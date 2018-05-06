package in.ogmatech.techstile.drycleanservice.controller;

import in.ogmatech.techstile.drycleanservice.exception.AlreadyExistsException;
import in.ogmatech.techstile.drycleanservice.modelWrapper.ItemWrapper;
import in.ogmatech.techstile.drycleanservice.model.Order;
import in.ogmatech.techstile.drycleanservice.service.OrderService;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsPdfView;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@RestController
@RequestMapping("/api/")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ApplicationContext applicationContext;


    /* Create new order */
    @PostMapping("orders/create")
    public ResponseEntity<ItemWrapper> create(@RequestBody ItemWrapper orderHelper){
        return new ResponseEntity<>(orderHelper, HttpStatus.CREATED);
    }

    /* Create a order */
    @PostMapping("orders")
    public ResponseEntity<Order> createOrder(@RequestBody Order order, UriComponentsBuilder ucBuilder) {

        if (orderService.isExist(order)) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        orderService.save(order);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("orders/{id}").buildAndExpand(order.getIdOrder()).toUri());

        return new ResponseEntity<>(order, headers, HttpStatus.CREATED);
    }

    /* Reading single order */
    @GetMapping(value = "orders/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Order> getOrder(@PathVariable("id") long idOrder) {

        Order order = orderService.findById(idOrder);

        if (order == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(order, HttpStatus.OK);


    }

   /* @GetMapping(value = "print/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ModelAndView getPrint(@PathVariable("id") long idOrder) {

        Order order = orderService.findById(idOrder);

        JasperReportsPdfView view = new JasperReportsPdfView();
        view.setUrl("classpath:test.jrxml");
        view.setApplicationContext(applicationContext);

        Map params = new HashMap();


        params.put("idOrder", "fine");



        return new ModelAndView(view, params);

    }*/

    @GetMapping(value = "print/{id}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public @ResponseBody ResponseEntity getPrint(@PathVariable("id") long idOrder) throws JRException,IOException {

        ResponseEntity responseEntity;

        Random random = new Random();
        int filename = random.nextInt(200000);

        List<Order> orders = orderService.findAll();

        String report = "src/main/resources/test.jrxml";
        JasperReport jreport = JasperCompileManager.compileReport(report);
        JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(orders);

        Map params = new HashMap();

        JasperPrint jprint = JasperFillManager.fillReport(jreport, params, ds);
        JasperExportManager.exportReportToPdfFile(jprint, "src/main/resources/"+filename+".pdf");

      //  JasperExportManager.exportReportToHtmlFile(jprint, "src/main/resources/"+filename+".html");

        InputStream inputStream = new FileInputStream("src/main/resources/"+filename+".pdf");

        byte[] out = IOUtils.toByteArray(inputStream);

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("content-disposition", "attachment; filename=" + filename+".pdf");
        responseHeaders.add("Cache-Control", "no-cache, no-store, must-revalidate");
        responseHeaders.add("Pragma", "no-cache");
        responseHeaders.add("Content-Type","application/pdf");

        responseEntity = new ResponseEntity(out, responseHeaders, HttpStatus.OK);

        return responseEntity;

    }

    /*Reads all orders*/
    @GetMapping(value = "orders", produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<List<Order>> listAllOrders() {

        List<Order> order = orderService.findAll();

        if (order.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    /*Update a order*/
    @PutMapping("orders/{id}")
    public ResponseEntity<Order> updateOrderFromDB(@PathVariable("id") Long idOrder, @RequestBody Order order) {

        Order currentOrder = orderService.findById(idOrder);

        if (currentOrder == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        orderService.update(idOrder, order);

        Order updatedOrder = orderService.findById(idOrder);

        return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
    }

    /*Delete a order */
    @DeleteMapping("orders/{id}")
    public ResponseEntity<Order> deleteOrderFromDB(@PathVariable("id") long idOrder) {

        Order order = orderService.findById(idOrder);

        if (order == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        orderService.delete(idOrder);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /*Delete all orders*/
    @DeleteMapping("orders")
    public ResponseEntity<Order> deleteAllOrders() {

        orderService.deleteAll();

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public String handleOrderAlreadyExistsException(AlreadyExistsException exception) {

        return exception.getMessage();
    }
}
