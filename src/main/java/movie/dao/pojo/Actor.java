package movie.dao.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.sql.Timestamp;
import java.util.Date;

@Data
@TableName(value = "mv_actor")
public class Actor {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    @TableField(value = "name", condition = SqlCondition.LIKE)
    @NotBlank(message = "影员名称不能为空")
    @Length(message = "影员名称最大长度为 {max} 个字符", max = 100)
    private String name;
    @TableField(value = "asName", condition = SqlCondition.LIKE)
    @Length(message = "影员别名最大长度为 {max} 个字符", max = 100)
    private String asName;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Past(message = "出生日期输入错误，必须为当前时间之前")
    private Date birthday;
    @NotBlank(message = "影员性别必须选择")
    private String sex;
    @NotNull(message = "出生国家必须选择")
    private Long countryId;
    @Length(message = "照片路径最大长度为 {max} 个字符", max = 100)
    private String avatar;
    @Length(message = "影员简介最大长度为 {max} 个字符", max = 100)
    private String context;
    @NotNull(message = "必须选择一个角色")
    private Long roleId;
    @TableField(value = "createTime", fill = FieldFill.INSERT)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp createTime;
    @TableField(value = "updateTime", fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp updateTime;
}
