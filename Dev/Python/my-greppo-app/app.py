from greppo import app

app.base_layer(
    name="CartoDB Light",
    visible=True,
    url="https://cartodb-basemaps-a.global.ssl.fastly.net/light_all/{z}/{x}/{y}@2x.png",
    subdomains=None,
    attribution='&copy; <a target="_blank" href="http://osm.org/copyright">OpenStreetMap</a> contributors',
)

app.base_layer(
    provider = "CartoDB Positron"
)
# Possible alternative names:

provider = "CartoDB Positron"
provider = "cartodbpositron"
provider = "cartodb-positron"
provider = "carto db/positron"
provider = "CARTO_DB_POSITRON"
provider = "CartoDB.Positron"