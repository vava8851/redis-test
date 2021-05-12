<h1>Redis</h1>
<ol>
<li>義大利人開發的記憶體快取記憶體資料庫。</li>
<li>全名 : Remote Dictionary Server。</li>
<li>他除了是一個Key-value pair的儲存系統(有點像我們Java寫的Map一樣)，還支援多種資料型別，比如:字串(String)，Hash(字典)，列表(List)，集合(Set)，有序集合(Sorted Set)。</li>
<li>物件存取操作有三種方法
<ul>
<li>基於JSON字串存取</li>
<li>基於序列化存取(不過就不跨平台)</li>
<li>基於Base64編碼存取(此方法常見，因為圖檔也能進去)</li>
</ul>
</li>
<li>效能極好，支援每秒10萬筆讀寫頻率。</li>
<li>Redis所有操作都是原子性的(一起成功或是一起失敗)</li>
<li>同時支援持久化操作，將記憶體資料同步到資料檔案中</li>
<li>還提供事務、訊息傳遞等功能。</li>
<li>在系統中，通常使用Redis做資料快取使用。</li>
</ol>
<p>#use intellij IDE<br />#use maven to build spring boot project</p>
