<#list pages as bookPage>
    <#if bookPage==-1>
        <li class="page-item disabled">
            <a class="page-link" href="#" tabindex="-1">...</a>
        </li>
    <#else>
        <li class="page-item">
            <a class="page-link" href="/guest-book/pagination?page=${bookPage-1}&itemsPerPage=${itemsPerPage}">
                ${bookPage}
            </a>
        </li>
    </#if>
</#list>
