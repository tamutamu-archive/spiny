# Expressui
> 基于 Easyui 的 Javascript 框架，可快速简单的设计企业级应用的 UI

## 引用示例
<script type="text/javascript" th:src="/jquery/jquery-1.11.3.js}" charset="UTF-8"></script>
<!--<script type="text/javascript" th:src="/jquery/jquery-1.11.3.min.js}" charset="UTF-8"></script>-->
<script type="text/javascript" th:src="/jquery-easyui-1.5.5.1/jquery.easyui.min.js}" charset="UTF-8"></script>
<script type="text/javascript" th:src="/jquery-easyui-1.5.5.1/locale/easyui-lang-zh_CN.js}" charset="UTF-8"></script>

<script type="text/javascript" th:src="/js/gioov.js}" charset="UTF-8"></script>
<script type="text/javascript" th:src="/expressui-0.1.0/js/expressui.js}" charset="UTF-8"></script>

## 使用示例
### dialog

- 新增
```
    easyui.dialog.create({
            title: '新增视图页面分类',
            grid:{ type:'treegrid', selector:'#viewPageCategory'},
            selector: '#viewPageCategoryAddDialog',
            href: Page.System.VIEW_PAGE_CATEGORY + '/add_dialog',
            save: {url: Api.System.VIEW_PAGE_CATEGORY + '/add_one', method:'post', param:{parentId:}},
        });
```