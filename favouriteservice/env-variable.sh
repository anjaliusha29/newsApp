export MYSQL_DATABASE=newsdb
export MYSQL_USER=root
export MYSQL_PASSWORD=Root@123
if [[ -z "${MYSQL_CI_URL}" ]]; then
export MYSQL_CI_URL=jdbc:mysql://localhost:3306/newsdb
fi
