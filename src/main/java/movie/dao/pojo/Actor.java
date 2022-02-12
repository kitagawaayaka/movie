package movie.dao.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import movie.config.BlankLength;
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
    @NotNull(message = "影员ID不能为空", groups = {UpdateActorGroup.class, DeleteActorGroup.class})
    private Long id;
    @TableField(value = "name", condition = SqlCondition.LIKE)
    @NotBlank(message = "影员名称不能为空", groups = {AddActorGroup.class})
    @Length(message = "影员名称长度为 {min} ~ {max} 个字符", min = 3, max = 100, groups = {AddActorGroup.class, UpdateActorGroup.class})
    private String name;
    @TableField(value = "asName", condition = SqlCondition.LIKE)
    @BlankLength(message = "影员别名长度为 {min} ~ {max} 个字符", min = 3,max = 100, groups = {AddActorGroup.class, UpdateActorGroup.class})
    private String asName;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Past(message = "出生日期输入错误，必须为当前时间之前", groups = {AddActorGroup.class, UpdateActorGroup.class})
    private Date birthday;
    @NotBlank(message = "影员性别必须选择", groups = {AddActorGroup.class, UpdateActorGroup.class})
    private String sex;
    @NotNull(message = "出生国家必须选择", groups = {AddActorGroup.class, UpdateActorGroup.class})
    private Long countryId;
    @BlankLength(message = "照片路径长度为 {min} ~ {max} 个字符", min = 3, max = 100, groups = {AddActorGroup.class, UpdateActorGroup.class})
    private String avatar;
    @BlankLength(message = "影员简介长度为 {min} ~ {max} 个字符", min = 3, max = 100, groups = {AddActorGroup.class, UpdateActorGroup.class})
    private String context;
    @NotNull(message = "必须选择一个角色", groups = {AddActorGroup.class, UpdateActorGroup.class})
    private Long roleId;
    @TableField(value = "createTime", fill = FieldFill.INSERT)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp createTime;
    @TableField(value = "updateTime", fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp updateTime;

    public interface AddActorGroup{}
    public interface DeleteActorGroup{}
    public interface UpdateActorGroup{}
}
