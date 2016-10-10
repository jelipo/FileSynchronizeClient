package cao.mine;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import cao.mine.file.FileCompare;
import cao.mine.file.FileTool;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class Main {
    public static final String address = "localhost";
    public static final int port = 12345;


    public static void main(String[] args) throws IOException {
//        System.out.println("客户端启动...初始化");
//        Context context=new Context();
//        System.out.println("开始连接服务器");
//        Socket socket = new Socket(context.getInitText().getString("serveraddress"), context.getInitText().getInteger("serverport"));
//        context.setSocket(socket);
//        MainFrame frame=new MainFrame(context);
//        context.setMainFrame(frame);
//        frame.showme();
        long a = System.currentTimeMillis();
        FileTool fileTool = new FileTool("C:/Users/10441/Desktop/Work");
        JSONObject json = fileTool.getFileStructure();
        System.out.println("执行耗时 : " + (System.currentTimeMillis() - a));
        System.out.println(json);
        JSONObject json2= JSON.parseObject("{\n" +
                "    \"好办法432.docx\": {\n" +
                "        \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\",\n" +
                "        \"isFile\": 1,\n" +
                "        \"md5\": \"d3ee211be70c41e6b91a90791543a6b0\"\n" +
                "    },\n" +
                "    \"编辑可研.doc\": {\n" +
                "        \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\",\n" +
                "        \"isFile\": 1,\n" +
                "        \"md5\": \"11aa0f1150b01bc2d142db8f31e5cc96\"\n" +
                "    },\n" +
                "    \"201601131827\": {\n" +
                "        \"css\": {\n" +
                "            \"normalize.css\": {\n" +
                "                \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\201601131827\\\\css\",\n" +
                "                \"isFile\": 1,\n" +
                "                \"md5\": \"3bc2f546340fb700ab9a155ff6bf45ab\"\n" +
                "            },\n" +
                "            \"default.css\": {\n" +
                "                \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\201601131827\\\\css\",\n" +
                "                \"isFile\": 1,\n" +
                "                \"md5\": \"b6513acb99d9cb43186383b1d3907f5f\"\n" +
                "            },\n" +
                "            \"jquery.popup.css\": {\n" +
                "                \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\201601131827\\\\css\",\n" +
                "                \"isFile\": 1,\n" +
                "                \"md5\": \"954ae555b1cdc625ed56d05fe6f0faf4\"\n" +
                "            }\n" +
                "        },\n" +
                "        \"related\": {\n" +
                "            \"2.jpg\": {\n" +
                "                \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\201601131827\\\\related\",\n" +
                "                \"isFile\": 1,\n" +
                "                \"md5\": \"7eea9a901f54e3390fd8b0fb86c59f0d\"\n" +
                "            },\n" +
                "            \"1.jpg\": {\n" +
                "                \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\201601131827\\\\related\",\n" +
                "                \"isFile\": 1,\n" +
                "                \"md5\": \"5f8c21236c1393084b2200583b800ace\"\n" +
                "            },\n" +
                "            \"Thumbs.db\": {\n" +
                "                \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\201601131827\\\\related\",\n" +
                "                \"isFile\": 1,\n" +
                "                \"md5\": \"b6e6ccdd0bf1fff499ef94da27f9b5b2\"\n" +
                "            }\n" +
                "        },\n" +
                "        \"fonts\": {\n" +
                "            \"icomoon.eot\": {\n" +
                "                \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\201601131827\\\\fonts\",\n" +
                "                \"isFile\": 1,\n" +
                "                \"md5\": \"3891455c55b76ce7f7c86bfc33cd6493\"\n" +
                "            },\n" +
                "            \"icomoon.woff\": {\n" +
                "                \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\201601131827\\\\fonts\",\n" +
                "                \"isFile\": 1,\n" +
                "                \"md5\": \"d1117ddce10d8c7ca18ac089764da08d\"\n" +
                "            },\n" +
                "            \"icomoon.ttf\": {\n" +
                "                \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\201601131827\\\\fonts\",\n" +
                "                \"isFile\": 1,\n" +
                "                \"md5\": \"e46c36b6f94cf81311ffb383f6d32bec\"\n" +
                "            },\n" +
                "            \"icomoon.svg\": {\n" +
                "                \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\201601131827\\\\fonts\",\n" +
                "                \"isFile\": 1,\n" +
                "                \"md5\": \"bb97ed129aa43f69280d3085cd269102\"\n" +
                "            }\n" +
                "        },\n" +
                "        \"readme.html\": {\n" +
                "            \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\201601131827\",\n" +
                "            \"isFile\": 1,\n" +
                "            \"md5\": \"1a60dc51ef2ad09b8d6f7e50433ae5a0\"\n" +
                "        },\n" +
                "        \"img-150x120.jpg\": {\n" +
                "            \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\201601131827\",\n" +
                "            \"isFile\": 1,\n" +
                "            \"md5\": \"5d376139905af626cefec81a0bdc2050\"\n" +
                "        },\n" +
                "        \"index.html\": {\n" +
                "            \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\201601131827\",\n" +
                "            \"isFile\": 1,\n" +
                "            \"md5\": \"78f740e44bfbcdca42db9a2999397342\"\n" +
                "        },\n" +
                "        \"ripple.min.js\": {\n" +
                "            \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\201601131827\",\n" +
                "            \"isFile\": 1,\n" +
                "            \"md5\": \"8c8e4940189855bc08aba58c59f68e59\"\n" +
                "        },\n" +
                "        \"js\": {\n" +
                "            \"jquery-1.11.0.min.js\": {\n" +
                "                \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\201601131827\\\\js\",\n" +
                "                \"isFile\": 1,\n" +
                "                \"md5\": \"a1cd7fc161a5cb1d7102d1e72ee1e67f\"\n" +
                "            },\n" +
                "            \"jquery.popup.js\": {\n" +
                "                \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\201601131827\\\\js\",\n" +
                "                \"isFile\": 1,\n" +
                "                \"md5\": \"6519e19c095abc2c3a16fa4578425d0b\"\n" +
                "            },\n" +
                "            \"jquery-2.1.4.min.js\": {\n" +
                "                \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\201601131827\\\\js\",\n" +
                "                \"isFile\": 1,\n" +
                "                \"md5\": \"b0dc11d0a434aafe88908c7f33d71095\"\n" +
                "            }\n" +
                "        },\n" +
                "        \"ripple.min.css\": {\n" +
                "            \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\201601131827\",\n" +
                "            \"isFile\": 1,\n" +
                "            \"md5\": \"e7f60921a577886814b8a4eb348c4288\"\n" +
                "        },\n" +
                "        \"jQuery之家.url\": {\n" +
                "            \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\201601131827\",\n" +
                "            \"isFile\": 1,\n" +
                "            \"md5\": \"7a9db6f94218fc80f08f0e5be9c369b0\"\n" +
                "        }\n" +
                "    },\n" +
                "    \"ssm\": {\n" +
                "        \".tern-project\": {\n" +
                "            \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\ssm\",\n" +
                "            \"isFile\": 1,\n" +
                "            \"md5\": \"54ca2042e8a31682dcbfa4867829fc51\"\n" +
                "        },\n" +
                "        \".classpath\": {\n" +
                "            \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\ssm\",\n" +
                "            \"isFile\": 1,\n" +
                "            \"md5\": \"cfed280350305b103f890e4a340abe5b\"\n" +
                "        },\n" +
                "        \"build\": {\n" +
                "            \"classes\": {\n" +
                "                \"com\": {\n" +
                "                    \"crm\": {\n" +
                "                        \"controller\": {\n" +
                "                            \"UserController.class\": {\n" +
                "                                \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\ssm\\\\build\\\\classes\\\\com\\\\crm\\\\controller\",\n" +
                "                                \"isFile\": 1,\n" +
                "                                \"md5\": \"366758f22d424432c25729994a8a7f90\"\n" +
                "                            }\n" +
                "                        },\n" +
                "                        \"dao\": {\n" +
                "                            \"impl\": {\n" +
                "                                \"UserDaoImpl.class\": {\n" +
                "                                    \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\ssm\\\\build\\\\classes\\\\com\\\\crm\\\\dao\\\\impl\",\n" +
                "                                    \"isFile\": 1,\n" +
                "                                    \"md5\": \"895f7aca867c6eb1d5d0fb3c9e06c443\"\n" +
                "                                }\n" +
                "                            },\n" +
                "                            \"UserDao.class\": {\n" +
                "                                \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\ssm\\\\build\\\\classes\\\\com\\\\crm\\\\dao\",\n" +
                "                                \"isFile\": 1,\n" +
                "                                \"md5\": \"cac4718a32785c47ded0a944a3f60e4c\"\n" +
                "                            }\n" +
                "                        },\n" +
                "                        \"util\": {\n" +
                "                            \"Pager.class\": {\n" +
                "                                \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\ssm\\\\build\\\\classes\\\\com\\\\crm\\\\util\",\n" +
                "                                \"isFile\": 1,\n" +
                "                                \"md5\": \"10b6f97d0a8c7d220f2c5c2e4b0bd63d\"\n" +
                "                            },\n" +
                "                            \"RetCode.class\": {\n" +
                "                                \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\ssm\\\\build\\\\classes\\\\com\\\\crm\\\\util\",\n" +
                "                                \"isFile\": 1,\n" +
                "                                \"md5\": \"1c949814cfc053e7bada7688a21c2d41\"\n" +
                "                            }\n" +
                "                        },\n" +
                "                        \"service\": {\n" +
                "                            \"impl\": {\n" +
                "                                \"UserServiceImpl.class\": {\n" +
                "                                    \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\ssm\\\\build\\\\classes\\\\com\\\\crm\\\\service\\\\impl\",\n" +
                "                                    \"isFile\": 1,\n" +
                "                                    \"md5\": \"268873e2a374cd267dda406780a35cf9\"\n" +
                "                                }\n" +
                "                            },\n" +
                "                            \"UserService.class\": {\n" +
                "                                \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\ssm\\\\build\\\\classes\\\\com\\\\crm\\\\service\",\n" +
                "                                \"isFile\": 1,\n" +
                "                                \"md5\": \"3d1a009af27a7fdb53ac40b057b885df\"\n" +
                "                            }\n" +
                "                        },\n" +
                "                        \"mapper\": {\n" +
                "                            \"UserMapper.class\": {\n" +
                "                                \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\ssm\\\\build\\\\classes\\\\com\\\\crm\\\\mapper\",\n" +
                "                                \"isFile\": 1,\n" +
                "                                \"md5\": \"e3d7ab67a516e8bcb3e0b37684238920\"\n" +
                "                            }\n" +
                "                        },\n" +
                "                        \"entity\": {\n" +
                "                            \"User.class\": {\n" +
                "                                \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\ssm\\\\build\\\\classes\\\\com\\\\crm\\\\entity\",\n" +
                "                                \"isFile\": 1,\n" +
                "                                \"md5\": \"357e64964715072fd63e5e9aab85100c\"\n" +
                "                            }\n" +
                "                        }\n" +
                "                    }\n" +
                "                },\n" +
                "                \"database.properties\": {\n" +
                "                    \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\ssm\\\\build\\\\classes\",\n" +
                "                    \"isFile\": 1,\n" +
                "                    \"md5\": \"1db90d40b1be190b19e57df63acc5e40\"\n" +
                "                },\n" +
                "                \"springContext\": {\n" +
                "                    \"applicationContext.xml\": {\n" +
                "                        \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\ssm\\\\build\\\\classes\\\\springContext\",\n" +
                "                        \"isFile\": 1,\n" +
                "                        \"md5\": \"8a0c1a6a24fb7d5ea4905e4d93e7bad5\"\n" +
                "                    }\n" +
                "                },\n" +
                "                \"mybatis.xml\": {\n" +
                "                    \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\ssm\\\\build\\\\classes\",\n" +
                "                    \"isFile\": 1,\n" +
                "                    \"md5\": \"e2b09d6d27a3117ca8fe9890041f27ae\"\n" +
                "                },\n" +
                "                \"log4j.properties\": {\n" +
                "                    \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\ssm\\\\build\\\\classes\",\n" +
                "                    \"isFile\": 1,\n" +
                "                    \"md5\": \"143f1f1b90be08b72aa7c9d8f88f5338\"\n" +
                "                },\n" +
                "                \"entity\": {\n" +
                "                    \"config\": {\n" +
                "                        \"user.xml\": {\n" +
                "                            \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\ssm\\\\build\\\\classes\\\\entity\\\\config\",\n" +
                "                            \"isFile\": 1,\n" +
                "                            \"md5\": \"a6f22f9c46f92284dca7705cf80f6df8\"\n" +
                "                        }\n" +
                "                    }\n" +
                "                }\n" +
                "            }\n" +
                "        },\n" +
                "        \"src\": {\n" +
                "            \"com\": {\n" +
                "                \"crm\": {\n" +
                "                    \"controller\": {\n" +
                "                        \"UserController.java\": {\n" +
                "                            \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\ssm\\\\src\\\\com\\\\crm\\\\controller\",\n" +
                "                            \"isFile\": 1,\n" +
                "                            \"md5\": \"4ccb6dbf5d6fc50d8f65b8f02e9e5a9c\"\n" +
                "                        }\n" +
                "                    },\n" +
                "                    \"dao\": {\n" +
                "                        \"impl\": {\n" +
                "                            \"UserDaoImpl.java\": {\n" +
                "                                \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\ssm\\\\src\\\\com\\\\crm\\\\dao\\\\impl\",\n" +
                "                                \"isFile\": 1,\n" +
                "                                \"md5\": \"01ae5dc8a98c8efba23ee86d9c508a45\"\n" +
                "                            }\n" +
                "                        },\n" +
                "                        \"UserDao.java\": {\n" +
                "                            \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\ssm\\\\src\\\\com\\\\crm\\\\dao\",\n" +
                "                            \"isFile\": 1,\n" +
                "                            \"md5\": \"37318af52ad8ab8ec24d236daaab5f22\"\n" +
                "                        }\n" +
                "                    },\n" +
                "                    \"util\": {\n" +
                "                        \"RetCode.java\": {\n" +
                "                            \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\ssm\\\\src\\\\com\\\\crm\\\\util\",\n" +
                "                            \"isFile\": 1,\n" +
                "                            \"md5\": \"6e5efafb143c491920b6469eee062638\"\n" +
                "                        },\n" +
                "                        \"Pager.java\": {\n" +
                "                            \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\ssm\\\\src\\\\com\\\\crm\\\\util\",\n" +
                "                            \"isFile\": 1,\n" +
                "                            \"md5\": \"fb0e480fbb4e6994f56a4136f629351c\"\n" +
                "                        }\n" +
                "                    },\n" +
                "                    \"service\": {\n" +
                "                        \"impl\": {\n" +
                "                            \"UserServiceImpl.java\": {\n" +
                "                                \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\ssm\\\\src\\\\com\\\\crm\\\\service\\\\impl\",\n" +
                "                                \"isFile\": 1,\n" +
                "                                \"md5\": \"f703df74b36fd1d4ff1cfed6871a187c\"\n" +
                "                            }\n" +
                "                        },\n" +
                "                        \"UserService.java\": {\n" +
                "                            \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\ssm\\\\src\\\\com\\\\crm\\\\service\",\n" +
                "                            \"isFile\": 1,\n" +
                "                            \"md5\": \"a3b38c097895b5e25e9037efec56344f\"\n" +
                "                        }\n" +
                "                    },\n" +
                "                    \"mapper\": {\n" +
                "                        \"UserMapper.java\": {\n" +
                "                            \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\ssm\\\\src\\\\com\\\\crm\\\\mapper\",\n" +
                "                            \"isFile\": 1,\n" +
                "                            \"md5\": \"1aa232c7505abae52bd81f8df9adedae\"\n" +
                "                        }\n" +
                "                    },\n" +
                "                    \"entity\": {\n" +
                "                        \"User.java\": {\n" +
                "                            \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\ssm\\\\src\\\\com\\\\crm\\\\entity\",\n" +
                "                            \"isFile\": 1,\n" +
                "                            \"md5\": \"2295703bc5dd742a051c286265172d84\"\n" +
                "                        }\n" +
                "                    }\n" +
                "                }\n" +
                "            },\n" +
                "            \"database.properties\": {\n" +
                "                \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\ssm\\\\src\",\n" +
                "                \"isFile\": 1,\n" +
                "                \"md5\": \"1db90d40b1be190b19e57df63acc5e40\"\n" +
                "            },\n" +
                "            \"springContext\": {\n" +
                "                \"applicationContext.xml\": {\n" +
                "                    \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\ssm\\\\src\\\\springContext\",\n" +
                "                    \"isFile\": 1,\n" +
                "                    \"md5\": \"8a0c1a6a24fb7d5ea4905e4d93e7bad5\"\n" +
                "                }\n" +
                "            },\n" +
                "            \"mybatis.xml\": {\n" +
                "                \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\ssm\\\\src\",\n" +
                "                \"isFile\": 1,\n" +
                "                \"md5\": \"e2b09d6d27a3117ca8fe9890041f27ae\"\n" +
                "            },\n" +
                "            \"log4j.properties\": {\n" +
                "                \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\ssm\\\\src\",\n" +
                "                \"isFile\": 1,\n" +
                "                \"md5\": \"143f1f1b90be08b72aa7c9d8f88f5338\"\n" +
                "            },\n" +
                "            \"entity\": {\n" +
                "                \"config\": {\n" +
                "                    \"user.xml\": {\n" +
                "                        \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\ssm\\\\src\\\\entity\\\\config\",\n" +
                "                        \"isFile\": 1,\n" +
                "                        \"md5\": \"a6f22f9c46f92284dca7705cf80f6df8\"\n" +
                "                    }\n" +
                "                }\n" +
                "            }\n" +
                "        },\n" +
                "        \".project\": {\n" +
                "            \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\ssm\",\n" +
                "            \"isFile\": 1,\n" +
                "            \"md5\": \"5f5e6bd497b5c20d570cc7a0d59a3847\"\n" +
                "        },\n" +
                "        \"WebContent\": {\n" +
                "            \"META-INF\": {\n" +
                "                \"MANIFEST.MF\": {\n" +
                "                    \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\ssm\\\\WebContent\\\\META-INF\",\n" +
                "                    \"isFile\": 1,\n" +
                "                    \"md5\": \"b10f37c8bb1803d98c127a01d1a71cc5\"\n" +
                "                }\n" +
                "            },\n" +
                "            \"login.jsp\": {\n" +
                "                \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\ssm\\\\WebContent\",\n" +
                "                \"isFile\": 1,\n" +
                "                \"md5\": \"f644501f084f76972c8ede838f9eeda3\"\n" +
                "            },\n" +
                "            \"WEB-INF\": {\n" +
                "                \"pages\": {\n" +
                "                    \"fail.jsp\": {\n" +
                "                        \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\ssm\\\\WebContent\\\\WEB-INF\\\\pages\",\n" +
                "                        \"isFile\": 1,\n" +
                "                        \"md5\": \"77fefd9c45722001c53164c316e98ffe\"\n" +
                "                    },\n" +
                "                    \"welcome.jsp\": {\n" +
                "                        \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\ssm\\\\WebContent\\\\WEB-INF\\\\pages\",\n" +
                "                        \"isFile\": 1,\n" +
                "                        \"md5\": \"51c2cead39aec851251c99edb45ee35f\"\n" +
                "                    }\n" +
                "                },\n" +
                "                \"lib\": {\n" +
                "                    \"org.springframework.web.servlet-3.0.6.RELEASE.jar\": {\n" +
                "                        \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\ssm\\\\WebContent\\\\WEB-INF\\\\lib\",\n" +
                "                        \"isFile\": 1,\n" +
                "                        \"md5\": \"4e6027259b7c60ca8c53ba50370ceedd\"\n" +
                "                    },\n" +
                "                    \"commons-dbcp.jar\": {\n" +
                "                        \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\ssm\\\\WebContent\\\\WEB-INF\\\\lib\",\n" +
                "                        \"isFile\": 1,\n" +
                "                        \"md5\": \"590f45b612433a50665bc4f369fc77d0\"\n" +
                "                    },\n" +
                "                    \"org.springframework.beans-3.0.6.RELEASE.jar\": {\n" +
                "                        \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\ssm\\\\WebContent\\\\WEB-INF\\\\lib\",\n" +
                "                        \"isFile\": 1,\n" +
                "                        \"md5\": \"ac57e6bf4324601ad550ec8caa60b3af\"\n" +
                "                    },\n" +
                "                    \"commons-lang-2.4.jar\": {\n" +
                "                        \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\ssm\\\\WebContent\\\\WEB-INF\\\\lib\",\n" +
                "                        \"isFile\": 1,\n" +
                "                        \"md5\": \"237a8e845441bad2e535c57d985c8204\"\n" +
                "                    },\n" +
                "                    \"org.springframework.aop-3.0.6.RELEASE.jar\": {\n" +
                "                        \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\ssm\\\\WebContent\\\\WEB-INF\\\\lib\",\n" +
                "                        \"isFile\": 1,\n" +
                "                        \"md5\": \"3a2fe17e3ac9d984a00159447d065e40\"\n" +
                "                    },\n" +
                "                    \"org.springframework.test-3.0.6.RELEASE.jar\": {\n" +
                "                        \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\ssm\\\\WebContent\\\\WEB-INF\\\\lib\",\n" +
                "                        \"isFile\": 1,\n" +
                "                        \"md5\": \"ef866488cebec1d9f81effe9bcf6d0a7\"\n" +
                "                    },\n" +
                "                    \"mybatis-spring-1.1.1.jar\": {\n" +
                "                        \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\ssm\\\\WebContent\\\\WEB-INF\\\\lib\",\n" +
                "                        \"isFile\": 1,\n" +
                "                        \"md5\": \"6c285d28f062906192b6225cfeaf0619\"\n" +
                "                    },\n" +
                "                    \"commons-pool.jar\": {\n" +
                "                        \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\ssm\\\\WebContent\\\\WEB-INF\\\\lib\",\n" +
                "                        \"isFile\": 1,\n" +
                "                        \"md5\": \"e48fa47bd0c1a31518df6cf79ac903b8\"\n" +
                "                    },\n" +
                "                    \"standard.jar\": {\n" +
                "                        \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\ssm\\\\WebContent\\\\WEB-INF\\\\lib\",\n" +
                "                        \"isFile\": 1,\n" +
                "                        \"md5\": \"65351d0487ad57edda9171bb3b46b98c\"\n" +
                "                    },\n" +
                "                    \"org.springframework.context.support-3.0.6.RELEASE.jar\": {\n" +
                "                        \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\ssm\\\\WebContent\\\\WEB-INF\\\\lib\",\n" +
                "                        \"isFile\": 1,\n" +
                "                        \"md5\": \"31e73d565880397bbbb9bf09c698b8d1\"\n" +
                "                    },\n" +
                "                    \"org.springframework.transaction-3.0.6.RELEASE.jar\": {\n" +
                "                        \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\ssm\\\\WebContent\\\\WEB-INF\\\\lib\",\n" +
                "                        \"isFile\": 1,\n" +
                "                        \"md5\": \"360407762c8d4399357cb0f79b6db719\"\n" +
                "                    },\n" +
                "                    \"commons-logging-1.1.1.jar\": {\n" +
                "                        \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\ssm\\\\WebContent\\\\WEB-INF\\\\lib\",\n" +
                "                        \"isFile\": 1,\n" +
                "                        \"md5\": \"ed448347fc0104034aa14c8189bf37de\"\n" +
                "                    },\n" +
                "                    \"org.springframework.orm-3.0.6.RELEASE.jar\": {\n" +
                "                        \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\ssm\\\\WebContent\\\\WEB-INF\\\\lib\",\n" +
                "                        \"isFile\": 1,\n" +
                "                        \"md5\": \"a2ec4bc8d9ae80223e9e8ff2f7e2846c\"\n" +
                "                    },\n" +
                "                    \"org.springframework.oxm-3.0.6.RELEASE.jar\": {\n" +
                "                        \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\ssm\\\\WebContent\\\\WEB-INF\\\\lib\",\n" +
                "                        \"isFile\": 1,\n" +
                "                        \"md5\": \"08b5a989f538717a4c3d1d738714d287\"\n" +
                "                    },\n" +
                "                    \"org.springframework.expression-3.0.6.RELEASE.jar\": {\n" +
                "                        \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\ssm\\\\WebContent\\\\WEB-INF\\\\lib\",\n" +
                "                        \"isFile\": 1,\n" +
                "                        \"md5\": \"388d8426cf01839cfa64e8bebcd3fdc2\"\n" +
                "                    },\n" +
                "                    \"org.springframework.core-3.0.6.RELEASE.jar\": {\n" +
                "                        \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\ssm\\\\WebContent\\\\WEB-INF\\\\lib\",\n" +
                "                        \"isFile\": 1,\n" +
                "                        \"md5\": \"150706f3fde5c658a478f3b053bc95e0\"\n" +
                "                    },\n" +
                "                    \"org.springframework.jdbc-3.0.6.RELEASE.jar\": {\n" +
                "                        \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\ssm\\\\WebContent\\\\WEB-INF\\\\lib\",\n" +
                "                        \"isFile\": 1,\n" +
                "                        \"md5\": \"b145c83e95f5aac012117575b3b9a98c\"\n" +
                "                    },\n" +
                "                    \"aopalliance-1.0.jar\": {\n" +
                "                        \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\ssm\\\\WebContent\\\\WEB-INF\\\\lib\",\n" +
                "                        \"isFile\": 1,\n" +
                "                        \"md5\": \"04177054e180d09e3998808efa0401c7\"\n" +
                "                    },\n" +
                "                    \"org.springframework.asm-3.0.6.RELEASE.jar\": {\n" +
                "                        \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\ssm\\\\WebContent\\\\WEB-INF\\\\lib\",\n" +
                "                        \"isFile\": 1,\n" +
                "                        \"md5\": \"380dea15ad6f32168a81b9f78e4d5056\"\n" +
                "                    },\n" +
                "                    \"jackson-mapper-asl-1.9.2.jar\": {\n" +
                "                        \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\ssm\\\\WebContent\\\\WEB-INF\\\\lib\",\n" +
                "                        \"isFile\": 1,\n" +
                "                        \"md5\": \"246dc2edd781021dce648e59dc839d85\"\n" +
                "                    },\n" +
                "                    \"org.springframework.aspects-3.0.6.RELEASE.jar\": {\n" +
                "                        \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\ssm\\\\WebContent\\\\WEB-INF\\\\lib\",\n" +
                "                        \"isFile\": 1,\n" +
                "                        \"md5\": \"24c664b7bbc7540d6a9b8afdd7f4b3fc\"\n" +
                "                    },\n" +
                "                    \"c3p0-0.9.1.2.jar\": {\n" +
                "                        \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\ssm\\\\WebContent\\\\WEB-INF\\\\lib\",\n" +
                "                        \"isFile\": 1,\n" +
                "                        \"md5\": \"45db3fd891e1f22cc90109ac7e473c73\"\n" +
                "                    },\n" +
                "                    \"jackson-core-asl-1.9.2.jar\": {\n" +
                "                        \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\ssm\\\\WebContent\\\\WEB-INF\\\\lib\",\n" +
                "                        \"isFile\": 1,\n" +
                "                        \"md5\": \"3a569b4b918f23392e63028b896cb9c4\"\n" +
                "                    },\n" +
                "                    \"mybatis-3.1.1.jar\": {\n" +
                "                        \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\ssm\\\\WebContent\\\\WEB-INF\\\\lib\",\n" +
                "                        \"isFile\": 1,\n" +
                "                        \"md5\": \"a2ebda40a5ddd197ebcb6b6b67bb686c\"\n" +
                "                    },\n" +
                "                    \"org.springframework.context-3.0.6.RELEASE.jar\": {\n" +
                "                        \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\ssm\\\\WebContent\\\\WEB-INF\\\\lib\",\n" +
                "                        \"isFile\": 1,\n" +
                "                        \"md5\": \"76b3e08da23032c93409989fb38579c2\"\n" +
                "                    },\n" +
                "                    \"log4j-1.2.16.jar\": {\n" +
                "                        \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\ssm\\\\WebContent\\\\WEB-INF\\\\lib\",\n" +
                "                        \"isFile\": 1,\n" +
                "                        \"md5\": \"363678f015902bcc040308136f845a3f\"\n" +
                "                    },\n" +
                "                    \"jstl-1.2.jar\": {\n" +
                "                        \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\ssm\\\\WebContent\\\\WEB-INF\\\\lib\",\n" +
                "                        \"isFile\": 1,\n" +
                "                        \"md5\": \"51e15f798e69358cb893e38c50596b9b\"\n" +
                "                    },\n" +
                "                    \"mysql-connector-java-5.1.22-bin.jar\": {\n" +
                "                        \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\ssm\\\\WebContent\\\\WEB-INF\\\\lib\",\n" +
                "                        \"isFile\": 1,\n" +
                "                        \"md5\": \"2c069d69928c75cd28172fd33772a1db\"\n" +
                "                    },\n" +
                "                    \"org.springframework.web-3.0.6.RELEASE.jar\": {\n" +
                "                        \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\ssm\\\\WebContent\\\\WEB-INF\\\\lib\",\n" +
                "                        \"isFile\": 1,\n" +
                "                        \"md5\": \"6d424afcc4a9c578420a5c6f99f9ffec\"\n" +
                "                    }\n" +
                "                },\n" +
                "                \"web.xml\": {\n" +
                "                    \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\ssm\\\\WebContent\\\\WEB-INF\",\n" +
                "                    \"isFile\": 1,\n" +
                "                    \"md5\": \"1056d2191ab671cd267fadb159737bc6\"\n" +
                "                },\n" +
                "                \"springmvc.xml\": {\n" +
                "                    \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\ssm\\\\WebContent\\\\WEB-INF\",\n" +
                "                    \"isFile\": 1,\n" +
                "                    \"md5\": \"b2c7481ba079674cbeeb790b8a563198\"\n" +
                "                }\n" +
                "            }\n" +
                "        },\n" +
                "        \".settings\": {\n" +
                "            \"org.eclipse.wst.common.project.facet.core.xml\": {\n" +
                "                \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\ssm\\\\.settings\",\n" +
                "                \"isFile\": 1,\n" +
                "                \"md5\": \"f0cd7393be70b75a732fa430fa4ec324\"\n" +
                "            },\n" +
                "            \"org.eclipse.wst.jsdt.ui.superType.name\": {\n" +
                "                \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\ssm\\\\.settings\",\n" +
                "                \"isFile\": 1,\n" +
                "                \"md5\": \"c89686a387d2b12b3c729ce35a0bcb5b\"\n" +
                "            },\n" +
                "            \"org.eclipse.wst.jsdt.ui.superType.container\": {\n" +
                "                \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\ssm\\\\.settings\",\n" +
                "                \"isFile\": 1,\n" +
                "                \"md5\": \"b27d1cf62dde4473bab7c433317bb0ce\"\n" +
                "            },\n" +
                "            \"org.eclipse.wst.common.component\": {\n" +
                "                \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\ssm\\\\.settings\",\n" +
                "                \"isFile\": 1,\n" +
                "                \"md5\": \"0885d187e729af98eb82c488501cbe77\"\n" +
                "            },\n" +
                "            \"org.eclipse.core.resources.prefs\": {\n" +
                "                \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\ssm\\\\.settings\",\n" +
                "                \"isFile\": 1,\n" +
                "                \"md5\": \"22442c867bc4d09d60813079ccf30c8c\"\n" +
                "            },\n" +
                "            \"org.eclipse.jdt.core.prefs\": {\n" +
                "                \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\ssm\\\\.settings\",\n" +
                "                \"isFile\": 1,\n" +
                "                \"md5\": \"8e002b3721607c3736c7e838f1a3984e\"\n" +
                "            },\n" +
                "            \".jsdtscope\": {\n" +
                "                \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\ssm\\\\.settings\",\n" +
                "                \"isFile\": 1,\n" +
                "                \"md5\": \"2dfb4ce067f1529d1934162e0152d9b8\"\n" +
                "            }\n" +
                "        }\n" +
                "    },\n" +
                "    \"Thumbs.db\": {\n" +
                "        \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\",\n" +
                "        \"isFile\": 1,\n" +
                "        \"md5\": \"bfb92dba02abe95ae37ae4ced903ab86\"\n" +
                "    },\n" +
                "    \"20160727_163730.jpg\": {\n" +
                "        \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\",\n" +
                "        \"isFile\": 1,\n" +
                "        \"md5\": \"2062f9509f8102d38bd42a2b29c74e3b\"\n" +
                "    },\n" +
                "    \"QQ图片20160722，090815.jpg\": {\n" +
                "        \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\",\n" +
                "        \"isFile\": 1,\n" +
                "        \"md5\": \"62ac58b73b2f4d937beaaa72ccc8a82d\"\n" +
                "    },\n" +
                "    \"测试手册.docx\": {\n" +
                "        \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\",\n" +
                "        \"isFile\": 1,\n" +
                "        \"md5\": \"cc0189da26e5821fde07e590dd5de55b\"\n" +
                "    },\n" +
                "    \"用户操作手册.zip\": {\n" +
                "        \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\",\n" +
                "        \"isFile\": 1,\n" +
                "        \"md5\": \"c411550d0f1774b921b5c8014b204516\"\n" +
                "    },\n" +
                "    \"QQ图片20160729155814.jpg\": {\n" +
                "        \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\",\n" +
                "        \"isFile\": 1,\n" +
                "        \"md5\": \"51080892f3d616559f4f9f3c54a348a0\"\n" +
                "    },\n" +
                "    \"AjaxUploadFile\": {\n" +
                "        \"up.php\": {\n" +
                "            \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\AjaxUploadFile\",\n" +
                "            \"isFile\": 1,\n" +
                "            \"md5\": \"aca0b856dae36d83743f0bfb1da526b1\"\n" +
                "        },\n" +
                "        \"js\": {\n" +
                "            \"AjaxUploadFile.js\": {\n" +
                "                \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\AjaxUploadFile\\\\js\",\n" +
                "                \"isFile\": 1,\n" +
                "                \"md5\": \"589ca53795d4224eaf6b4baebf3a684a\"\n" +
                "            }\n" +
                "        },\n" +
                "        \"demo.html\": {\n" +
                "            \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\AjaxUploadFile\",\n" +
                "            \"isFile\": 1,\n" +
                "            \"md5\": \"a36d334439b8e0ebd5d5d4864654ba52\"\n" +
                "        },\n" +
                "        \"README.md\": {\n" +
                "            \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\\\\AjaxUploadFile\",\n" +
                "            \"isFile\": 1,\n" +
                "            \"md5\": \"d733599cf5623ff660a1cd1358a44025\"\n" +
                "        }\n" +
                "    },\n" +
                "    \"一些bug或问题.docx\": {\n" +
                "        \"path\": \"C:\\\\Users\\\\10441\\\\Desktop\\\\Work\",\n" +
                "        \"isFile\": 1,\n" +
                "        \"md5\": \"8106098ba6368c1ed14f952bdfc0e0d3\"\n" +
                "    }\n" +
                "}");
        FileCompare com=new FileCompare();
        com.compare(json2,json);
        System.out.println(com.getCompareList());
        //System.out.println(json.keySet().iterator().next());
//        isFile(ob);
//        System.out.println("执行耗时 : " + (System.currentTimeMillis() - a));
    }



}
