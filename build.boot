(set-env!
 :resource-paths #{"src" "test"}
 :dependencies '[[org.jgroups/jgroups "4.0.0.Final"]
                 [adzerk/boot-test "1.2.0" :scope "test"]])

(require '[adzerk.boot-test :refer [test]])

(task-options!
 pom {:project 'clj-groups
      :version "0.1.0-SNAPSHOT"}
 jar {})
