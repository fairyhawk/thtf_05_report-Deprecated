/**
 * ClassName  RSellBackConvertHelper
 *
 * History
 * Create User: jiangstar
 * Create Date: 2010-10-18
 * Update User:
 * Update Date:
 */
package cn.com.thtf.cms.report.convert;

import java.math.RoundingMode;

import org.springframework.dao.DataAccessException;

import cn.com.thtf.cms.report.entity.StockProductDetailEntity;

/**
 * rReceiveInvoice转换辅助
 * 
 * @author jiangstar
 */
public class RStockProductDetailConvertHelper implements ConvertHelper {

    /**
     * @see cn.com.thtf.egov.cms.batch.convert.ConvertHelper#getTilte()
     */
    @Override
    public String[] getTilte() {
        return new String[] { "库房名称", "产品分类名称", "产品系列名称", "产品编码", "产品名称", "规格型号", "单位",
                "库存总数", "库存单价", "库存金额" };
    }

    /**
     * @see cn.com.thtf.egov.cms.batch.convert.ConvertHelper#getRow(Object)
     */
    @SuppressWarnings("serial")
    @Override
    public String[] getRow(Object obj) {
        if (!(obj instanceof StockProductDetailEntity)) {
            throw new DataAccessException(
                    "row data must be StockProductDetailEntity type") {
            };
        }
        StockProductDetailEntity stockProductDetail = (StockProductDetailEntity) obj;
        String[] row = new String[10];
        row[0] = stockProductDetail.getStockroomName();
        row[1] = stockProductDetail.getProductTypeName();
        row[2] = stockProductDetail.getProductSerieName();
        row[3] = stockProductDetail.getProductCode();
        row[4] = stockProductDetail.getProductName();

        row[5] = stockProductDetail.getProductType();
        row[6] = stockProductDetail.getProductUnit();
        row[7] = String.valueOf(stockProductDetail.getStockroomCount());
        if (stockProductDetail.getStockroomPrice() != null) {
            row[8] = stockProductDetail.getStockroomPrice()
                    .setScale(2, RoundingMode.HALF_UP).toString();
        } else {
            row[8] = "";
        }
        if (stockProductDetail.getStockroomMoney() != null) {
            row[9] = stockProductDetail.getStockroomMoney()
                    .setScale(2, RoundingMode.HALF_UP).toString();
        } else {
            row[9] = "";
        }

        return row;
    }
}
